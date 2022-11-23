package com.prpymes.microservicios.app.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.prpymes.microservicios.app.compras.models.entity"})
public class MicroserviciosComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosComprasApplication.class, args);
	}

}
