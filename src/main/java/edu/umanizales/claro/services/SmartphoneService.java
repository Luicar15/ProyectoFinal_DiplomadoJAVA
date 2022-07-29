package edu.umanizales.claro.services;

import edu.umanizales.claro.entities.Smartphone;
import edu.umanizales.claro.repositories.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/smartphone")
public class SmartphoneService {

    @Autowired
    //ClienteRepository sRepository;
    SmartphoneRepository cRepository;

    @PostMapping("/guardarvarios")
    public String crearStock(@RequestBody List<Smartphone> smartphone){
        try{
            cRepository.saveAll(smartphone);
            return "Guardada Lista con exito";
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al guardar el usuario");
        }
    }

    @PostMapping("/guardarstock")
    public String crearStock(@RequestBody Smartphone smartphone){
        try{
            cRepository.save(smartphone);
            return "Guardado con exito";
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al guardar el usuario");
        }
    }

    @DeleteMapping("/EliminarSmartphone/{id}")
    public String eliminarCelular(@PathVariable("id") Long id){
        try{
            cRepository.deleteById(id);
            return "Borrado con exito";
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al borrar el usuario");
        }
    }

    @DeleteMapping("/EliminarStock")
    public String eliminarStock(){
        cRepository.deleteAll();
        return "Eliminado todo";
    }

    @GetMapping("/ListarSmartphone")
    public List<Smartphone> Listar(){
        return cRepository.findAll();
    }
    @GetMapping("/BuscarSmartphone/marca/{marca}/modelo/{modelo}")
    public Smartphone buscar(@PathVariable("marca") String marca, @PathVariable("modelo") String modelo){
        return cRepository.findByMarcaAndModelo(marca, modelo);
    }
}
