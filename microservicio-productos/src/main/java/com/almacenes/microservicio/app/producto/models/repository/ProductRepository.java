package com.almacenes.microservicio.app.producto.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.almacenes.microservicio.commons.product.models.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query("select p from Product p where p.name like %?1% or p.description like %?1%")
	public List<Product> findByNameOrDescription(String term);

	@Query(value="SELECT * FROM product P WHERE P.category = 'MANUFACTURA'", nativeQuery=true)
	public List<Product> getProductManufactured();

	@Query(value="SELECT * FROM product P WHERE P.category != 'MANUFACTURA'", nativeQuery=true)
	public List<Product> getProductPedido();
}
