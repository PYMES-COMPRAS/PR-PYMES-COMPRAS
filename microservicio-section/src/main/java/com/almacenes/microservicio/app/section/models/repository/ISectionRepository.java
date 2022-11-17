package com.almacenes.microservicio.app.section.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.almacenes.microservicio.commons.section.models.entity.Section;

public interface ISectionRepository extends CrudRepository<Section, Long> {
	@Query("SELECT s FROM Section s JOIN FETCH s.racks r WHERE r.idRack=?1")
	public Section findSectionByRackID(Long id);
}
