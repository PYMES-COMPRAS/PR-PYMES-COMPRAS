package com.prpymes.microservicios.app.compras.services;

import org.springframework.stereotype.Service;

import com.prpymes.microservicios.app.compras.models.entity.Producto;
import com.prpymes.microservicios.app.compras.models.repository.ProductoRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImplC;

@Service
public class ProductoServiceImpl extends CommonServiceImplC<Producto, ProductoRepository> implements ProductoService {
    
}
