package com.pymes.compras.app.presupuestos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.pymes.commons.models.entity.Presupuesto;

public interface PresupuestoRepository extends CrudRepository<Presupuesto, Integer>{
    
}
