package com.prpymes.microservicios.app.librodiario.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.librodiario.models.entity.Cuentas;
import com.prpymes.microservicios.app.librodiario.services.CuentaService;

@EnableEurekaClient
@RestController
public class CuentaController {

	@Autowired
	private CuentaService service;
	
	@GetMapping("/Cuenta/{id}")
	public ResponseEntity<?> listar(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findByIdEmpresa(id));
	}
	
	@GetMapping("/CodigoCuenta/{id}")
	public ResponseEntity<?> listar(@PathVariable String id){
		return ResponseEntity.ok().body(service.findByCodigoCuenta(id));
	}
	
	@PostMapping("/Cuenta")
	public ResponseEntity<?> crear(@RequestBody Cuentas cuenta){
		Cuentas cuentaDb = service.save(cuenta);
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaDb);
	}
	@PutMapping("/Cuenta/{id}")
	public ResponseEntity<?> editar(@RequestBody Cuentas cuenta,@PathVariable Long id){
		Optional<Cuentas> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Cuentas cuentaDb = o.get();
		cuentaDb.setDenominacion(cuenta.getDenominacion());
		cuentaDb.setCodigoCuenta(cuenta.getCodigoCuenta());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cuentaDb)); 
	}
	
	@DeleteMapping("/Cuenta/{id}")
	public ResponseEntity<?> borrarLogico(@PathVariable Long id){
		Optional<Cuentas> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Cuentas cuentaDb = o.get();
		cuentaDb.setStatus(0);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cuentaDb)); 
	}
}
