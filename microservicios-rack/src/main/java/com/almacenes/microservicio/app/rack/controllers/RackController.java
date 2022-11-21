package com.almacenes.microservicio.app.rack.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.almacenes.microservicio.app.rack.services.RackService;
import com.almacenes.microservicio.commons.product.models.entity.Product;
import com.almacenes.microservicio.commons.rack.models.entity.Rack;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class RackController extends CommonController<Rack, RackService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Rack rack, @PathVariable Long id){
		Optional<Rack> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Rack dbRack = o.get();
		dbRack.setDescription(rack.getDescription());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbRack));
	}
	
	@PutMapping("/{id}/asignar-productos")
	public ResponseEntity<?> addProducts(@RequestBody List<Product> products, @PathVariable Long id){
		Optional<Rack> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Rack dbRack = o.get();
		
		products.forEach(a -> {
			dbRack.addProducts(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbRack));
	}
	
	@PutMapping("/{id}/eliminar-producto")
	public ResponseEntity<?> deleteProduct(@RequestBody Product product, @PathVariable Long id){
		Optional<Rack> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Rack dbRack = o.get();
		
		dbRack.removeProducts(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbRack));
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> findByProductId(@PathVariable Long id){
		Rack rack = service.findRackByProductId(id);
		return ResponseEntity.ok(rack);
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filter(@PathVariable String term){
		return ResponseEntity.ok(service.findRacksByDescription(term));
	}
}
