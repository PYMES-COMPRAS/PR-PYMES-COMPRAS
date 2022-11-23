package com.prpymes.microservicios.app.compras.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prpymes.microservicios.app.compras.models.entity.Manufactura;

public interface ManufacturaRepository extends PagingAndSortingRepository<Manufactura, Integer> {
    
}
