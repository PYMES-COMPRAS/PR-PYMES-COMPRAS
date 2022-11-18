package com.pymes.compras.app.produccion.services;

import org.springframework.stereotype.Service;

import com.pymes.commons.models.entity.Produccion;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.produccion.models.repository.ProduccionRepository;

@Service
public class ProduccionServiceImpl extends CommonServiceImpl<Produccion, ProduccionRepository> implements ProduccionService{
    
}
