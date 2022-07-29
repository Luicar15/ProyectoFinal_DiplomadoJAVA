package edu.umanizales.claro.services;


import edu.umanizales.claro.entities.Cliente;
import edu.umanizales.claro.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteService {

    @Autowired
    ClienteRepository cRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        if(cRepository.existsByNombre(name))
            return "Hello";
        return String.format("Hello %s!", name);
    }

    @PostMapping("/guardar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String crearCliente(@RequestBody Cliente cliente){
        try{
            cRepository.save(cliente);
            return "Guardado con exito";
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al guardar el usuario");
        }
    }

    @GetMapping("/Listar")
    public List<Cliente> Listar(){
        return cRepository.findAll();
    }

    @GetMapping("/Buscar/{nombre}")
    public List<Cliente> buscar(@PathVariable("nombre") String nombre){
        return cRepository.findByNombre(nombre);
    }

    @DeleteMapping("/Eliminar/{id}")
    public String Eliminar(@PathVariable("id") Long id){
        try{
            cRepository.deleteById(id);
            return "Borrado con exito";
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al borrar el usuario");
        }
    }

}
