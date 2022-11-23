package com.prpymes.microservicios.app.compras.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prpymes.microservicios.app.compras.models.entity.Producto;

public interface ProductoRepository extends PagingAndSortingRepository<Producto, Integer> {
    
}
