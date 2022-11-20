package com.pymes.compras.app.proveedores.services;

import java.util.List;

import com.pymes.commons.models.entity.Proveedor;
import com.pymes.commons.services.CommonService;

public interface ProveedorService extends CommonService<Proveedor>{
    public List<Proveedor> findByNombre(String term);
	
    public List<Object> findPresupuestosForProvedor(Integer idProveedor);

}
