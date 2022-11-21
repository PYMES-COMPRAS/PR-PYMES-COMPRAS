package com.almacenes.microservicio.app.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.almacenes.microservicio.commons.product.models.entity",
	"com.almacenes.microservicio.commons.rack.models.entity",
	"com.almacenes.microservicio.commons.section.models.entity",
	"com.almacenes.microservicio.app.warehouse.models.entity"
	})
public class MicroservicioWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioWarehouseApplication.class, args);
	}

}
