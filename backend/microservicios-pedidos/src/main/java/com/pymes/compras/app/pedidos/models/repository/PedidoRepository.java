package com.pymes.compras.app.pedidos.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pymes.commons.models.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
    
    @Query(value = "SELECT po.nombre as Nombre, dp.cantidad as Producto, dp.descuento as Descuento, dp.precio_unitario as 'Precio Unitario' FROM pm_c_pedido p INNER JOIN pm_c_detallepedido dp ON p.id_pedido = dp.id_pedido INNER JOIN pm_b_producto po ON po.id_producto = dp.id_producto WHERE p.id_pedido =:id", nativeQuery = true)
    public List<Object> showPedidoById(@Param("id") Integer id);
    
}
