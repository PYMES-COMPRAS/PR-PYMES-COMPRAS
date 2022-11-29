package com.prpymes.microservicios.app.compras.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.compras.models.entity.Pedido;

public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long> {
    
    @Query(value = "SELECT po.nombre as Nombre, dp.cantidad as Producto, dp.descuento as Descuento, dp.precio_unitario as 'Precio Unitario' FROM pm_c_pedido p INNER JOIN pm_c_detallepedido dp ON p.id = dp.id_pedido INNER JOIN pm_b_producto po ON po.id = dp.id_producto WHERE p.id =:id", nativeQuery = true)
    public List<Object> showPedidoById(@Param("id") Long id);
    
    @Query(value = "SELECT pre.ref_presupuesto, pro.nombre, p.fecha_orden, p.fecha_entrega, pre.base_imponible, p.estado FROM pm_c_pedido p INNER JOIN pm_c_presupuesto pre ON pre.id = p.id_presupuesto INNER JOIN pm_c_proveedor pro ON pro.id = pre.id_proveedor", nativeQuery = true)
    public List<Object> listarPedidos();

    @Query(value="SELECT P.id, P.condiciones_pago, P.divisa, P.estado, P.fecha_entrega, P.fecha_orden, P.metodo_pedido, P.nota, P.tipo_pago, P.update_date, P.id_presupuesto, DP.id AS idDetallePedido, DP.cantidad, DP.descuento, DP.precio_unitario, DP.id_producto FROM pm_c_pedido P INNER JOIN pm_c_detallepedido DP ON P.id = DP.id_pedido", nativeQuery = true)
    public List<Object> innerJoinDetallePedidos();
    
}
