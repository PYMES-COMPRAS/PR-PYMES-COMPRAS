package com.pymes.compras.app.presupuestos.services;

import org.springframework.stereotype.Service;

import com.pymes.commons.models.entity.Presupuesto;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.presupuestos.models.repository.PresupuestoRepository;

@Service
public class PresupuestoServiceImpl extends CommonServiceImpl<Presupuesto, PresupuestoRepository> implements PresupuestoService {
    
}
