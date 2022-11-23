package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.compras.models.entity.Proveedor;
import com.prpymes.microservicios.app.compras.models.repository.ProveedorRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class ProveedorServiceImpl extends CommonServiceImpl<Proveedor, ProveedorRepository> implements ProveedorService {

    @Override
	@Transactional(readOnly = true)
	public List<Proveedor> findByNombre(String term) {
		return repository.findByNombre(term);
	}

    @Override
    @Transactional(readOnly = true)
	public List<Object> findPresupuestosForProvedor(Integer idProveedor){
		return repository.findPresupuestosForProvedor(idProveedor);
	}
    
}
