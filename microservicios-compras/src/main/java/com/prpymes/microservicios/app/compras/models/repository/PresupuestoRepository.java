package com.prpymes.microservicios.app.compras.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prpymes.microservicios.app.compras.models.entity.Presupuesto;

public interface PresupuestoRepository extends PagingAndSortingRepository<Presupuesto, Integer>{
    
    @Query(value="SELECT pre.id, pre.id_proveedor, pro.nombre , pre.ref_presupuesto, pre.base_imponible, pre.descuentos, pre.fecha_inicio, pre.presupuesto_actual, pre.estado, pre.update_date FROM pm_c_presupuesto pre INNER JOIN pm_c_proveedor pro on pre.id_proveedor = pro.id", nativeQuery = true)
    public List<Object> joinPresupuestoWithProveedor();
}
