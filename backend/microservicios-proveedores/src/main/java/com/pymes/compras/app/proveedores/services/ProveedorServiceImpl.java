package com.pymes.compras.app.proveedores.services;

import org.springframework.stereotype.Service;

import com.pymes.commons.proveedores.models.entity.Proveedor;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.proveedores.models.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl extends CommonServiceImpl<Proveedor, ProveedorRepository> implements ProveedorService {
    
}
