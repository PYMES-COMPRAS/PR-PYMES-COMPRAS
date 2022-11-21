package com.prpymes.microservicios.app.ventas.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.services.VentaService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class VentaController extends CommonController<Venta, VentaService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Venta venta, @PathVariable Long id){
		Optional<Venta> v = service.findById(id);
		if(v.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		Venta ventaDb = v.get();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ventaDb));
		
	}
}
