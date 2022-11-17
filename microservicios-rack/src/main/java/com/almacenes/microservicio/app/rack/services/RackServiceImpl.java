package com.almacenes.microservicio.app.rack.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacenes.microservicio.app.rack.models.repository.RackRepository;
import com.almacenes.microservicio.commons.rack.models.entity.Rack;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class RackServiceImpl extends CommonServiceImpl<Rack, RackRepository> implements RackService {

	@Override
	@Transactional(readOnly=true)
	public Rack findRackByProductId(Long id) {
		return repository.findRackByProductId(id);
	}

	@Override
	public List<Rack> findRacksByDescription(String term) {
		// TODO Auto-generated method stub
		return repository.findRacksByDescription(term);
	}

}
