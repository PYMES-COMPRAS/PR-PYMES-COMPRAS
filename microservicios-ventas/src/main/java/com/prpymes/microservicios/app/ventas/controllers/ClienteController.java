package com.prpymes.microservicios.app.ventas.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.ventas.models.entity.Cliente;
import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.services.ClienteService;
import com.prpymes.microservicios.app.ventas.services.VentaService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class ClienteController   {

	@Autowired
	protected ClienteService service;
	
	@GetMapping("/cliente")
	public ResponseEntity<?> listar()
	{
		return ResponseEntity .ok().body(service.findAll());
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		Optional<Cliente> v = service.findById(id);
		
		if(v.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity .ok().body(v.get());
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<?> crear(@RequestBody Cliente e )
	{
		Cliente ventaDb = service.save(e);
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaDb);
	}
	
	
	
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	

	
}
