package edu.umanizales.claro;

import edu.umanizales.claro.entities.Cliente;
import edu.umanizales.claro.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@SpringBootApplication
public class ClaroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaroApplication.class, args);
	}

}
