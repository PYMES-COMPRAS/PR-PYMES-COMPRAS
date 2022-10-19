package com.prpymes.microservicios.app.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosVentasApplication.class, args);
	}

}
