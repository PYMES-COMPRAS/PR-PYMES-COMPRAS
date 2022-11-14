package com.pymes.compras.app.presupuestos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pymes.commons.models.entity.Presupuesto;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.presupuestos.models.repository.PresupuestoRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class PresupuestoServiceImpl extends CommonServiceImpl<Presupuesto, PresupuestoRepository> implements PresupuestoService {
    
    
	@Override
    @Transactional(readOnly = true)
	public List<Object> joinPresupuestoWithProveedor(){
		return repository.joinPresupuestoWithProveedor();
	}
}
