package com.pymes.compras.app.manufacturas.services;

import org.springframework.stereotype.Service;

import com.pymes.commons.models.entity.Manufactura;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.manufacturas.models.repository.ManufacturaRepository;

@Service
public class ManufacturaServiceImpl extends CommonServiceImpl<Manufactura, ManufacturaRepository> implements ManufacturaService {
    
}
