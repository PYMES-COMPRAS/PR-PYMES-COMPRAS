package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import com.prpymes.microservicios.app.compras.models.entity.Presupuesto;
import com.prpymes.microservicios.commons.services.CommonService;

public interface PresupuestoService extends CommonService<Presupuesto>{
    
    public List<Object> joinPresupuestoWithProveedor();
}
