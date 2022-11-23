package com.prpymes.microservicios.app.compras.services;

import org.springframework.stereotype.Service;

import com.prpymes.microservicios.app.compras.models.entity.Produccion;
import com.prpymes.microservicios.app.compras.models.repository.ProduccionRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class ProduccionServiceImpl extends CommonServiceImpl<Produccion, ProduccionRepository> implements ProduccionService {
    
}
