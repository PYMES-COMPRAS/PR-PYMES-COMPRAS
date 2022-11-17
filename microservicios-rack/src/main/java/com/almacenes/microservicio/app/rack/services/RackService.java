package com.almacenes.microservicio.app.rack.services;

import java.util.List;

import com.almacenes.microservicio.commons.rack.models.entity.Rack;
import com.prpymes.microservicios.commons.services.CommonService;


public interface RackService extends CommonService<Rack> {
	public Rack findRackByProductId(Long id);
	public List<Rack> findRacksByDescription(String term);
}
