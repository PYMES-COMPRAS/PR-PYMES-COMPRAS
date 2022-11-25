package com.prpymes.microservicios.app.compras.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prpymes.microservicios.app.compras.models.entity.Proveedor;

public interface ProveedorRepository extends PagingAndSortingRepository<Proveedor, Integer>{
    
    @Query(value="SELECT * FROM pm_c_proveedor PR WHERE PR.nombre LIKE ?1% ", nativeQuery = true)
	public List<Proveedor> findByNombre(String term);

    //@Query("SELECT new Users(e.id, e.email, e.firstname, e.surname) FROM Users e")
    @Query(value="SELECT PRE.* FROM pm_c_proveedor PR INNER JOIN pm_c_presupuesto PRE ON PRE.id_proveedor = PR.id WHERE PRE.id_proveedor = ?1", nativeQuery = true)
	public List<Object> findPresupuestosForProvedor(Integer idProveedor);
    
}
