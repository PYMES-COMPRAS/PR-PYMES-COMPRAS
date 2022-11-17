package com.pymes.compras.app.productos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.pymes.commons.models.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    
}
