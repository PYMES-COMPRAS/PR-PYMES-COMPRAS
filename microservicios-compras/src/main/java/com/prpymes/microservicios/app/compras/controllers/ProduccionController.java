package com.prpymes.microservicios.app.compras.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.Manufactura;
import com.prpymes.microservicios.app.compras.models.entity.Produccion;
import com.prpymes.microservicios.app.compras.services.ProduccionService;
import com.prpymes.microservicios.commons.controllers.CommonControllerC;

@RestController
public class ProduccionController extends CommonControllerC<Produccion, ProduccionService> {
    
    @Override
	@GetMapping("/producciones")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/producciones/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Produccion> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(o.get());
	}

	@Override
	@GetMapping("/producciones/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@Override
	@PostMapping("/producciones")
	public ResponseEntity<?> crear(@RequestBody Produccion produccion) {
		Produccion produccionDb = service.save(produccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(produccionDb);
	}

	@Override
	@DeleteMapping("/producciones/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/producciones/manufactura")
	public ResponseEntity<?> innerJoinManufactura(Pageable pageable) {
		return ResponseEntity.ok().body(service.innerJoinManufacturas());
	}

	@PutMapping("/producciones/{id}/agregar-manufacturas")
    public ResponseEntity<?> agregarPresupuestos(@RequestBody List<Manufactura> manufacturas, @PathVariable Long id){
        Optional<Produccion> o = this.service.findById(id);
        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Produccion produccionDb = o.get();

        manufacturas.forEach(a -> {
            produccionDb.addManufactura(a);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(produccionDb));
    }

}
