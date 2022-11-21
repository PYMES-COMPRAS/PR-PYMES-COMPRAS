package com.almacenes.microservicio.app.section.services;

import com.almacenes.microservicio.commons.section.models.entity.Section;
import com.prpymes.microservicios.commons.services.CommonService;


public interface ISectionService extends CommonService<Section> {
	public Section findSectionByRackID(Long id);
}
