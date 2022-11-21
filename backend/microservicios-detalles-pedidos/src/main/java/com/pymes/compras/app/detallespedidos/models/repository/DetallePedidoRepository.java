package com.pymes.compras.app.detallespedidos.models.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.pymes.commons.models.entity.DetallePedido;

public interface DetallePedidoRepository extends PagingAndSortingRepository<DetallePedido, Integer> {
    
    @Query(value="SELECT sum(dp.precio_unitario*dp.cantidad) AS TOTAL, pe.fecha_entrega FROM pm_c_detallepedido dp INNER JOIN pm_c_pedido pe ON pe.id = dp.id_pedido WHERE pe.fecha_entrega BETWEEN :from AND :to", nativeQuery = true)
	public List<Object> findByDateTotal(@Param("from") LocalDate from,@Param("to") LocalDate to);
}
