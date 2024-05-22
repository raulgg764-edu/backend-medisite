package com.medicinegg.microserviciomedicos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Microservicio medicos",version = "1.0", description = "Dedicado a las operaciones de los medicos y sus detalles"))
@SpringBootApplication
public class MicroservicioMedicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioMedicosApplication.class, args);
	}

}
