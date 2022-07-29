package edu.umanizales.claro.repositories;

import edu.umanizales.claro.entities.Cliente;
import edu.umanizales.claro.entities.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    @RestResource(path = "Buscar-marca")
    public Smartphone findByMarcaAndModelo(@Param("marca") String marca, @Param("modelo") String modelo);

    @RestResource(path = "Buscar-smartphone")
    public List<Smartphone> findByMarca(@Param("marca") String marca);
}
