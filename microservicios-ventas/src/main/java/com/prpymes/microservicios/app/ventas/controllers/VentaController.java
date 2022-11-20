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

import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.services.VentaService;

@RestController
public class VentaController {
	
	@Autowired
	private VentaService service;
	
	@GetMapping
	public ResponseEntity<?> listar()
	{
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		Optional <Venta> v = service.findById(id);
		if(v.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(v.get()); 
	}
	
	@PostMapping 
	public ResponseEntity<?> crear(@RequestBody Venta venta)
	{
		Venta ventaDb = service.save(venta);
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Venta venta, @PathVariable Long id )
	{
		Optional <Venta> v = service.findById(id);
		if(v.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		
		Venta ventaDb = v.get();
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ventaDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar (@PathVariable Long id)
	{
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
