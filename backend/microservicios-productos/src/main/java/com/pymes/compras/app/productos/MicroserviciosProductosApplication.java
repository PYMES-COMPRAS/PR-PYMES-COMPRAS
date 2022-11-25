package com.pymes.compras.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.pymes.commons.models.entity"})
public class MicroserviciosProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosProductosApplication.class, args);
	}

}
