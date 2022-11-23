package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.compras.models.entity.Presupuesto;
import com.prpymes.microservicios.app.compras.models.repository.PresupuestoRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class PresupuestoServiceImpl extends CommonServiceImpl<Presupuesto, PresupuestoRepository> implements PresupuestoService {

    @Override
    @Transactional(readOnly = true)
	public List<Object> joinPresupuestoWithProveedor(){
		return repository.joinPresupuestoWithProveedor();
	}
    
}
