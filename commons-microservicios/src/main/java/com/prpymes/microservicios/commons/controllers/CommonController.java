package com.prpymes.microservicios.commons.controllers;

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

import com.prpymes.microservicios.commons.services.CommonService;


public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> listar()
	{
		return ResponseEntity .ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		Optional<E> v = service.findById(id);
		
		if(v.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity .ok().body(v.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E e )
	{
		E ventaDb = service.save(e);
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaDb);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
