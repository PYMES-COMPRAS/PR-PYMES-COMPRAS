package com.almacenes.microservicio.app.section;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.almacenes.microservicio.commons.product.models.entity",
	"com.almacenes.microservicio.commons.rack.models.entity",
	"com.almacenes.microservicio.commons.section.models.entity"})
public class MicroservicioSectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioSectionApplication.class, args);
	}

}
