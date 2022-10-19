package com.prpymes.microservicios.app.almacenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosAlmacenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosAlmacenesApplication.class, args);
	}

}
