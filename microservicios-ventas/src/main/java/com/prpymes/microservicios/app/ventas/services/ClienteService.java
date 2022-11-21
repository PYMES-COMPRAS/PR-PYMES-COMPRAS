package com.prpymes.microservicios.app.ventas.services;

import com.prpymes.microservicios.app.ventas.models.entity.Cliente;

import com.prpymes.microservicios.commons.services.CommonService;


public interface ClienteService extends CommonService<Cliente>{
	public Iterable<Cliente> findByNombreNitCi(String term);
}
