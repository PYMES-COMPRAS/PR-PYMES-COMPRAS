package com.almacenes.microservicio.app.warehouse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.almacenes.microservicio.app.warehouse.models.entity.Warehouse;
import com.almacenes.microservicio.app.warehouse.services.IWarehouseService;

import com.almacenes.microservicio.commons.section.models.entity.Section;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class WarehouseController extends CommonController<Warehouse, IWarehouseService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Warehouse warehouse, @PathVariable Long id){
		Optional<Warehouse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Warehouse dbWarehouse = o.get();
		dbWarehouse.setDescription(warehouse.getDescription());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbWarehouse));
	}
	
	@PutMapping("/{id}/asignar-section")
	public ResponseEntity<?> addSections(@RequestBody List<Section> sections, @PathVariable Long id){
		Optional<Warehouse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Warehouse dbWarehouse = o.get();
		
		sections.forEach(a -> {
			dbWarehouse.addSection(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbWarehouse));
	}
	
	@PutMapping("/{id}/eliminar-section")
	public ResponseEntity<?> deleteSection(@RequestBody Section section, @PathVariable Long id){
		Optional<Warehouse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Warehouse dbWarehouse = o.get();
		
		dbWarehouse.removeRack(section);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbWarehouse));
	}
	
	@GetMapping("/Section/{id}")
	public ResponseEntity<?> findBySectionId(@PathVariable Long id){
		Section section = service.findWarehouseBySectionID(id);
		return ResponseEntity.ok(section);
	}
}
