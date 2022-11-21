package com.almacenes.microservicio.app.warehouse.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.almacenes.microservicio.app.warehouse.models.entity.Warehouse;
import com.almacenes.microservicio.commons.section.models.entity.Section;

public interface IWarehouseRepository extends CrudRepository<Warehouse, Long> {
	@Query("SELECT w FROM Warehouse w JOIN FETCH w.sections s WHERE s.idSection=?1")
	public Section findWarehouseBySectionID(Long id);
}
