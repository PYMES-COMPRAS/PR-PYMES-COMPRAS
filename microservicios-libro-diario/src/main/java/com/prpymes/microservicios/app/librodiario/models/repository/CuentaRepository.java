package com.prpymes.microservicios.app.librodiario.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.librodiario.models.entity.Cuentas;


public interface CuentaRepository extends CrudRepository<Cuentas , Long>{
	
	@Query ("select a from Cuentas a where a.idEmpresa = :id_empresa and a.status = 1")
	Iterable<Cuentas> findByIdEmpresa(@Param("id_empresa") Long id_empresa);
	
	@Query ("select a from Cuentas a where a.codigoCuenta = :codigoCuenta and a.status = 1")
	Cuentas findByCodigoCuenta(@Param("codigoCuenta") String codigoCuenta);
	
}
