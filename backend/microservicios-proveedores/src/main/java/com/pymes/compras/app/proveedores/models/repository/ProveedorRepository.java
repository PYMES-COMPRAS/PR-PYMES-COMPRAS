package com.pymes.compras.app.proveedores.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pymes.commons.models.entity.Proveedor;

public interface ProveedorRepository extends PagingAndSortingRepository<Proveedor, Integer>{
    
    @Query(value="SELECT * FROM pm_c_proveedor PR WHERE PR.nombre LIKE ?1% ", nativeQuery = true)
	public List<Proveedor> findByNombre(String term);

    //@Query("SELECT new Users(e.id, e.email, e.firstname, e.surname) FROM Users e")
    @Query(value="SELECT PRE.* FROM pm_c_proveedor PR INNER JOIN pm_c_presupuesto PRE ON PRE.idProveedor = PR.id WHERE PRE.idProveedor = ?1", nativeQuery = true)
	public List<Object> findPresupuestosForProvedor(Integer idProveedor);
    
}
