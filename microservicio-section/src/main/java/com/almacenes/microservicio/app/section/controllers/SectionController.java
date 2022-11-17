package com.almacenes.microservicio.app.section.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.almacenes.microservicio.app.section.services.ISectionService;
import com.almacenes.microservicio.commons.rack.models.entity.Rack;
import com.almacenes.microservicio.commons.section.models.entity.Section;
import com.prpymes.microservicios.commons.controllers.CommonController;
@RestController
public class SectionController extends CommonController<Section, ISectionService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Section section, @PathVariable Long id){
		Optional<Section> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Section dbSection = o.get();
		dbSection.setDescription(section.getDescription());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSection));
	}
	
	@PutMapping("/{id}/asignar-rack")
	public ResponseEntity<?> addRacks(@RequestBody List<Rack> racks, @PathVariable Long id){
		Optional<Section> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Section dbSection = o.get();
		
		racks.forEach(a -> {
			dbSection.addRacks(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSection));
	}
	
	@PutMapping("/{id}/eliminar-rack")
	public ResponseEntity<?> deleteRack(@RequestBody Rack rack, @PathVariable Long id){
		Optional<Section> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Section dbSection = o.get();
		
		dbSection.removeRack(rack);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSection));
	}
	
	@GetMapping("/rack/{id}")
	public ResponseEntity<?> findByRackId(@PathVariable Long id){
		Section section = service.findSectionByRackID(id);
		return ResponseEntity.ok(section);
	}
}
