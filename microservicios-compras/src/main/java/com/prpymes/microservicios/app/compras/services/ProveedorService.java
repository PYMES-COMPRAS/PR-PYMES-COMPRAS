package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import com.prpymes.microservicios.app.compras.models.entity.Proveedor;
import com.prpymes.microservicios.commons.services.CommonServiceC;

public interface ProveedorService extends CommonServiceC<Proveedor>{
    public List<Proveedor> findByNombre(String term);
	
    public List<Object> findPresupuestosForProvedor(Long idProveedor);

}
