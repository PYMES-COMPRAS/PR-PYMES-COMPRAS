package com.prpymes.microservicios.app.compras.services;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.compras.models.entity.Produccion;
import com.prpymes.microservicios.app.compras.models.repository.ProduccionRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImplC;

@Service
public class ProduccionServiceImpl extends CommonServiceImplC<Produccion, ProduccionRepository> implements ProduccionService {

    @Override
    @Transactional(readOnly = true)
    public List<Object> innerJoinManufacturas() {
        return repository.innerJoinManufacturas();
    }
    
}
