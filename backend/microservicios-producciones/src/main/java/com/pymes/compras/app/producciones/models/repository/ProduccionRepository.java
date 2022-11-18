package com.pymes.compras.app.producciones.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.pymes.commons.models.entity.Produccion;

public interface ProduccionRepository extends CrudRepository<Produccion, Integer>{
    
}
