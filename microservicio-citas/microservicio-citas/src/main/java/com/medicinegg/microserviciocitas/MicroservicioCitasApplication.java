package com.medicinegg.microserviciocitas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(info = @Info(title = "Microservicio citas",version = "1.0", description = "Dedicado a las operaciones de pacientes y citas"))
@SpringBootApplication
@EnableFeignClients
public class MicroservicioCitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCitasApplication.class, args);
	}

}
