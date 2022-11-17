package com.almacenes.microservicio.app.warehouse.services;

import com.almacenes.microservicio.app.warehouse.models.entity.Warehouse;
import com.almacenes.microservicio.commons.section.models.entity.Section;
import com.prpymes.microservicios.commons.services.CommonService;


public interface IWarehouseService extends CommonService<Warehouse> {
	public Section findWarehouseBySectionID(Long id);
}
