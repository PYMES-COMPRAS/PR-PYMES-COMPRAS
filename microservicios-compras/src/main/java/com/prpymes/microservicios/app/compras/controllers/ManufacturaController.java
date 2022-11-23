package com.prpymes.microservicios.app.compras.controllers;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.Manufactura;
import com.prpymes.microservicios.app.compras.services.ManufacturaService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class ManufacturaController extends CommonController<Manufactura, ManufacturaService> {
    
    @Override
	@GetMapping("/manufaturas/")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/manufaturas/{id}")
	public ResponseEntity<?> ver(@PathVariable Integer id) {
		Optional<Manufactura> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(o.get());
	}

	@Override
	@GetMapping("/manufaturas/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@Override
	@PostMapping("/manufaturas/")
	public ResponseEntity<?> crear(@RequestBody Manufactura manufactura) {
		Manufactura manufacturaDb = service.save(manufactura);
		return ResponseEntity.status(HttpStatus.CREATED).body(manufacturaDb);
	}

	@Override
	@DeleteMapping("/manufaturas/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
    
}
