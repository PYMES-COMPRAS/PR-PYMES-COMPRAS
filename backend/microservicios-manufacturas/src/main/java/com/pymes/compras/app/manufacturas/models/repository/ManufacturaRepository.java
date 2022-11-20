package com.pymes.compras.app.manufacturas.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pymes.commons.models.entity.Manufactura;

public interface ManufacturaRepository extends PagingAndSortingRepository<Manufactura, Integer> {
    
}
