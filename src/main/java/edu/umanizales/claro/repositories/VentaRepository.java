package edu.umanizales.claro.repositories;

import edu.umanizales.claro.entities.Cliente;
import edu.umanizales.claro.entities.Vendedor;
import edu.umanizales.claro.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {


}
