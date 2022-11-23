package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import com.prpymes.microservicios.app.compras.models.entity.Proveedor;
import com.prpymes.microservicios.commons.services.CommonService;

public interface ProveedorService extends CommonService<Proveedor>{
    public List<Proveedor> findByNombre(String term);
	
    public List<Object> findPresupuestosForProvedor(Integer idProveedor);

}
