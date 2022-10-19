package com.prpymes.microservicios.app.librodiario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosLibroDiarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosLibroDiarioApplication.class, args);
	}

}
