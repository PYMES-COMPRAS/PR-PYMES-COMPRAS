package com.pymes.compras.app.presupuestos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.pymes.commons.models.entity"})
public class MicroserviciosPresupuestosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPresupuestosApplication.class, args);
	}

}
