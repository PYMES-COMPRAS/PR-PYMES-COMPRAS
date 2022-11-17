package com.almacenes.microservicio.app.producto.services;

import java.util.List;

import com.almacenes.microservicio.commons.product.models.entity.Product;
import com.prpymes.microservicios.commons.services.CommonService;


public interface ProductService extends CommonService<Product> {
	
	public List<Product> findByNameOrDescription(String term);
}
