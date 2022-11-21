package com.prpymes.microservicios.app.librodiario.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.librodiario.models.entity.LibroDiario;
import com.prpymes.microservicios.app.librodiario.services.LibroDiarioService;

@EnableEurekaClient
@RestController
public class LibroDiarioController {
	
	@Autowired
	private LibroDiarioService service;
	
	@GetMapping("/mostrar")
	public ResponseEntity<?> mostrarPorFechas(@RequestParam Date fecha_inicio, @RequestParam Date fecha_fin, @RequestParam String tipo_libro)
	{
		return ResponseEntity.ok(service.findByDatesAndBookType(fecha_inicio, fecha_fin, tipo_libro));
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody LibroDiario librodiario){
		LibroDiario librodiarioDb = service.save(librodiario);
		return ResponseEntity.status(HttpStatus.CREATED).body(librodiarioDb);
	}
	
	
}
