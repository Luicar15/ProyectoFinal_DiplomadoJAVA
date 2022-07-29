package edu.umanizales.claro.services;


import edu.umanizales.claro.entities.Vendedor;
import edu.umanizales.claro.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/vendedor")
public class VendedorService {

    @Autowired
    private VendedorRepository vRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        if(vRepository.existsByNombre(name))
            return "Hello";
        return String.format("Hello %s!", name);
    }

    @PostMapping("/guardar")
    public Vendedor guardarVendedor(@RequestBody Vendedor vendedor){
        vendedor.setCodigoEmpleado(vendedor.getCedula());
        return vRepository.save(vendedor);
    }

    @PutMapping("/actualizar")
    public Vendedor actualizarVendedor(@RequestBody Vendedor vendedor){
        Vendedor v = vRepository.findByCedula(vendedor.getCedula());
        if(vendedor.getCedula()!=null) {
            v.setCodigoEmpleado(vendedor.getCedula());
            v.setCedula(vendedor.getCedula());
        }
        if(vendedor.getTipo()!=null)
            v.setTipo(vendedor.getTipo());
        if(vendedor.getNombre()!=null)
            v.setNombre(vendedor.getNombre());
        if(vendedor.getEnumEstado()!=null)
            v.setEnumEstado(vendedor.getEnumEstado());
        return vRepository.save(v);
    }


}
