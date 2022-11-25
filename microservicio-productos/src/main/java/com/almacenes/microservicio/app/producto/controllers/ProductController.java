package com.almacenes.microservicio.app.producto.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.almacenes.microservicio.app.producto.services.ProductService;

import com.almacenes.microservicio.commons.product.models.entity.Product;

import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class ProductController extends CommonController<Product, ProductService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Product product, @PathVariable Long id){
		Optional<Product> p = service.findById(id);
		if(p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Product productDb = p.get();
		productDb.setName(product.getName());
		productDb.setQuantity(product.getQuantity());
		productDb.setDescription(product.getDescription());
		productDb.setExpireDate(product.getExpireDate());
		productDb.setBrand(product.getBrand());
		productDb.setPrice(product.getPrice());
		productDb.setBarcode(product.getBarcode());
		productDb.setDiscount(product.getDiscount());
		productDb.setSupplier(product.getSupplier());
		productDb.setIva(product.getIva());
		productDb.setCategory(product.getCategory());
		productDb.setBatch(product.getBatch());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filter(@PathVariable String term){
		return ResponseEntity.ok(service.findByNameOrDescription(term));
	}
	
}
