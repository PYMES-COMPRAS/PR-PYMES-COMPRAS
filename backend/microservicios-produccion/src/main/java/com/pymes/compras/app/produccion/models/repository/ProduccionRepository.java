package com.pymes.compras.app.produccion.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pymes.commons.models.entity.Produccion;

public interface ProduccionRepository extends PagingAndSortingRepository<Produccion, Integer> {
    
}
