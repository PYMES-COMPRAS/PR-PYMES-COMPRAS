package com.prpymes.microservicios.app.compras.services;

import org.springframework.stereotype.Service;

import com.prpymes.microservicios.app.compras.models.entity.Manufactura;
import com.prpymes.microservicios.app.compras.models.repository.ManufacturaRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImplC;

@Service
public class ManufacturaServiceImpl extends CommonServiceImplC<Manufactura, ManufacturaRepository> implements ManufacturaService {
    
}
