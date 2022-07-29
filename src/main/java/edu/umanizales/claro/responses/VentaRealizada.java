package edu.umanizales.claro.responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VentaRealizada {

    private String nombre;
    private String cedula;
    private String marca;
    private BigDecimal precioCompra;
    private String nombreVendedor;

}
