package com.prpymes.microservicios.app.portalventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosPortalVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPortalVentasApplication.class, args);
	}

}
