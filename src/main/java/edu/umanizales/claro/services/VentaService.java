package edu.umanizales.claro.services;

import edu.umanizales.claro.entities.Cliente;
import edu.umanizales.claro.entities.Smartphone;
import edu.umanizales.claro.entities.Vendedor;
import edu.umanizales.claro.entities.Venta;
import edu.umanizales.claro.entities.enums.EnumTipoVendedor;
import edu.umanizales.claro.repositories.ClienteRepository;
import edu.umanizales.claro.repositories.SmartphoneRepository;
import edu.umanizales.claro.repositories.VendedorRepository;
import edu.umanizales.claro.repositories.VentaRepository;
import edu.umanizales.claro.responses.VentaRealizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaService {

    @Autowired
    VentaRepository vRepository;

    @Autowired
    ClienteRepository cRepository;

    @Autowired
    SmartphoneRepository sRepository;

    @Autowired
    VendedorRepository vendedorRepository;

    @GetMapping("/ventaRealizada/")
    public VentaRealizada venta(@RequestParam("cedula") String cedula,
                                @RequestParam("marca") String marca,
                                @RequestParam("modelo") String modelo,
                                @RequestParam("cedulaVendedor") String cedulaVendedor,
                                @RequestParam(value = "ciudad", required = false, defaultValue = "")String ciudad,
                                @RequestParam("anio") String anio,
                                @RequestParam("mes") String mes){
        Venta venta = new Venta();
        venta.setAnio(anio);
        venta.setMes(mes);
        VentaRealizada ventaRealizada = new VentaRealizada();
        Smartphone smartphone = sRepository.findByMarcaAndModelo(marca,modelo);
        Vendedor vendedor = vendedorRepository.findByCedula(cedulaVendedor);
        if(vendedor.getTipo() == EnumTipoVendedor.FISICO){
            if(ciudad.isEmpty() || ciudad.isBlank()){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Ciudad es necesaria");
            }
            venta.setCiudad(ciudad);
        }
        Cliente cliente = cRepository.findByCedula(cedula);
        ventaRealizada.setNombre(cliente.getNombre());
        ventaRealizada.setCedula(cedula);
        ventaRealizada.setMarca(smartphone.getMarca());
        ventaRealizada.setPrecioCompra(smartphone.getPrecio_compra());
        ventaRealizada.setNombreVendedor(vendedor.getNombre());
        BigInteger resta = new BigInteger("1");
        BigInteger bI = smartphone.getCantidad().subtract(resta);
        smartphone.setCantidad(bI);

        venta.setCliente(cliente);
        venta.setVendedor(vendedor);
        venta.setSmartphone(smartphone);

        sRepository.save(smartphone);
        vRepository.save(venta);
        return ventaRealizada;
    }




}
