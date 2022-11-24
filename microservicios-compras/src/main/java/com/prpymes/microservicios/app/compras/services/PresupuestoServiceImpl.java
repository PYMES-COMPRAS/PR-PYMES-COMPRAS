package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.compras.models.entity.Presupuesto;
import com.prpymes.microservicios.app.compras.models.repository.PresupuestoRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImplC;

@Service
public class PresupuestoServiceImpl extends CommonServiceImplC<Presupuesto, PresupuestoRepository> implements PresupuestoService {

    @Override
    @Transactional(readOnly = true)
	public List<Object> joinPresupuestoWithProveedor(){
		return repository.joinPresupuestoWithProveedor();
	}
    
}
