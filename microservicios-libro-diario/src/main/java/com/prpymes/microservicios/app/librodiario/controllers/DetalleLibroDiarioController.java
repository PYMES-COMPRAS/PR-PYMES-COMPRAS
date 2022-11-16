package com.prpymes.microservicios.app.librodiario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.librodiario.models.entity.DetalleLibroDiario;
import com.prpymes.microservicios.app.librodiario.services.DetalleLibroDiarioService;

@EnableEurekaClient
@RestController
public class DetalleLibroDiarioController {
	@Autowired
	private DetalleLibroDiarioService service;
	
	@PostMapping("/detalle")
	public ResponseEntity<?> crear(@RequestBody DetalleLibroDiario detallelibrodiario) {
		DetalleLibroDiario detallelibrodiarioDb = service.save(detallelibrodiario);
		return ResponseEntity.status(HttpStatus.CREATED).body(detallelibrodiarioDb);
	}
}
