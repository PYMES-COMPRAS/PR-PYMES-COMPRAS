package com.pymes.compras.app.proveedores.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.pymes.commons.proveedores.models.entity.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long>{
    
}
