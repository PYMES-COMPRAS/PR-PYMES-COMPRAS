package com.prpymes.microservicios.app.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosFacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosFacturacionApplication.class, args);
	}

}
