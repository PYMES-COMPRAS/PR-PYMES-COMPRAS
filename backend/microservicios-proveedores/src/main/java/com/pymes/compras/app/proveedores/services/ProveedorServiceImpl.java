package com.pymes.compras.app.proveedores.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pymes.commons.models.entity.Presupuesto;
import com.pymes.commons.models.entity.Proveedor;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.proveedores.models.repository.ProveedorRepository;

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
