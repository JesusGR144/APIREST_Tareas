package com.example.ApiRestTareas;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiRestTareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestTareasApplication.class, args);
	}
	
	@GetMapping(path = "/")
	public List<String> getNames(){
		return List.of(
			"Juan", "Marcos", "Lucas"
		);
	}
}
