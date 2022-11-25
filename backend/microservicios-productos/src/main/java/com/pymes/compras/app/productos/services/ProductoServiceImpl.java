package com.pymes.compras.app.productos.services;

import org.springframework.stereotype.Service;

import com.pymes.commons.models.entity.Producto;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.productos.models.repository.ProductoRepository;

@Service
public class ProductoServiceImpl extends CommonServiceImpl<Producto, ProductoRepository> implements ProductoService {
    
}
