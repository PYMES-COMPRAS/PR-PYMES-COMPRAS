package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import com.prpymes.microservicios.app.compras.models.entity.Produccion;
import com.prpymes.microservicios.commons.services.CommonServiceC;

public interface ProduccionService extends CommonServiceC<Produccion>{
    public List<Object> innerJoinManufacturas();
}
