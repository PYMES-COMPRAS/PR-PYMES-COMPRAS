package com.almacenes.microservicio.app.producto.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacenes.microservicio.app.producto.models.repository.ProductRepository;
import com.almacenes.microservicio.commons.product.models.entity.Product;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;


@Service
public class ProductServiceImpl extends CommonServiceImpl<Product, ProductRepository> implements ProductService {

	@Override
	@Transactional(readOnly = true)
	public List<Product> findByNameOrDescription(String term) {
		return repository.findByNameOrDescription(term);
	}

	@Override
	public List<Product> getProductManufactured() {
		return repository.getProductManufactured();
	}

	@Override
	public List<Product> getProductPedido() {
		return repository.getProductPedido();
	}

}
