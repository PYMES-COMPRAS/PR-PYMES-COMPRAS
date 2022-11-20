package com.pymes.compras.app.productos.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pymes.commons.models.entity.Producto;

public interface ProductoRepository extends PagingAndSortingRepository<Producto, Integer> {
    
}
