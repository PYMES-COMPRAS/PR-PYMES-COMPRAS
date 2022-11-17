package com.almacenes.microservicio.app.rack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.almacenes.microservicio.commons.product.models.entity",
	"com.almacenes.microservicio.commons.rack.models.entity"})
public class MicroserviciosRackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosRackApplication.class, args);
	}

}
