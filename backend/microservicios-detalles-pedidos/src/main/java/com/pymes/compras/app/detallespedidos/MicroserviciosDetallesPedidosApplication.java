package com.pymes.compras.app.detallespedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.pymes.commons.models.entity"})
public class MicroserviciosDetallesPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosDetallesPedidosApplication.class, args);
	}

}
