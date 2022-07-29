package edu.umanizales.claro.repositories;

import edu.umanizales.claro.entities.Cliente;
import edu.umanizales.claro.entities.Smartphone;
import edu.umanizales.claro.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @RestResource(path = "Exists Cedula")
    public Vendedor findByCedula(@Param("cedula") String cedula);
    @RestResource(path = "Exists Nombre")
    public Boolean existsByNombre(@Param("nombre") String nombre);

}
