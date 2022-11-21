package com.prpymes.microservicios.app.librodiario.services;

import java.util.Optional;

import com.prpymes.microservicios.app.librodiario.models.entity.Cuentas;


public interface CuentaService {
	public Iterable<Cuentas> findByIdEmpresa(Long id_empresa);
	
	public Optional<Cuentas> findById(Long id);
	
	public Cuentas findByCodigoCuenta(String codigoCuenta);
	
	public Cuentas save(Cuentas alumno);
	
	public void deleteById(Long id);
	
}
