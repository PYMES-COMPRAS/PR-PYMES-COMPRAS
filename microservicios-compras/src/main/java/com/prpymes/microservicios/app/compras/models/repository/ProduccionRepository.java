package com.prpymes.microservicios.app.compras.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prpymes.microservicios.app.compras.models.entity.Produccion;

public interface ProduccionRepository extends PagingAndSortingRepository<Produccion, Integer>{
    
}
