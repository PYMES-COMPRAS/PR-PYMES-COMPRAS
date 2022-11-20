package com.pymes.compras.app.presupuestos.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pymes.commons.models.entity.Presupuesto;

public interface PresupuestoRepository extends PagingAndSortingRepository<Presupuesto, Integer>{
    
    @Query(value="SELECT pre.id, pre.idProveedor, pro.nombre , pre.ref_presupuesto, pre.base_imponible, pre.descuentos, pre.fecha_inicio, pre.presupuesto_actual, pre.estado, pre.update_date, pre.user_update FROM pm_c_presupuesto pre INNER JOIN pm_c_proveedor pro on pre.idProveedor = pro.id", nativeQuery = true)
    public List<Object> joinPresupuestoWithProveedor();
}
