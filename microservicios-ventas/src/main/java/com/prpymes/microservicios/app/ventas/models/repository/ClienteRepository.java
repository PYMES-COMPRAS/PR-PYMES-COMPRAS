package com.prpymes.microservicios.app.ventas.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.ventas.models.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	@Query(value ="select * from Clientes  where nombre like %?1% or nit_Ci like %?1%", nativeQuery= true)
	public Iterable<Cliente> findByNombreNitCi(@Param("term") String term);
}
