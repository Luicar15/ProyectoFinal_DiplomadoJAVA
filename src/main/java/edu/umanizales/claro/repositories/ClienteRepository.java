package edu.umanizales.claro.repositories;

import edu.umanizales.claro.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @RestResource(path = "Buscar Nombre")
    public List<Cliente> findByNombre(@Param("nombre") String nombre);

    @RestResource(path = "Buscar Cedula")
    public Cliente findByCedula(@Param("cedula") String cedula);

    @RestResource(path = "Exists Nombre")
    public Boolean existsByNombre(@Param("nombre") String nombre);

}
