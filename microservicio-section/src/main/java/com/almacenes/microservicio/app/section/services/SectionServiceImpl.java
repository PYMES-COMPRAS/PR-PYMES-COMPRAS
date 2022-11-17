package com.almacenes.microservicio.app.section.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacenes.microservicio.app.section.models.repository.ISectionRepository;
import com.almacenes.microservicio.commons.section.models.entity.Section;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class SectionServiceImpl extends CommonServiceImpl<Section, ISectionRepository>  implements ISectionService{

	@Override
	@Transactional(readOnly=true)
	public Section findSectionByRackID(Long id) {
		// TODO Auto-generated method stub
		return repository.findSectionByRackID(id);
	}

}
