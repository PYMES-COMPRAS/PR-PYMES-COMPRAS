package com.almacenes.microservicio.app.warehouse.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacenes.microservicio.app.warehouse.models.entity.Warehouse;
import com.almacenes.microservicio.app.warehouse.models.repository.IWarehouseRepository;
import com.almacenes.microservicio.commons.section.models.entity.Section;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class WarehouseServiceImpl extends CommonServiceImpl<Warehouse, IWarehouseRepository> implements IWarehouseService {

	@Override
	@Transactional(readOnly=true)
	public Section findWarehouseBySectionID(Long id) {
		// TODO Auto-generated method stub
		return repository.findWarehouseBySectionID(id);
	}

}
