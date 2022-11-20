package com.pymes.compras.app.detallespedidos.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pymes.commons.models.entity.DetallePedido;

public interface DetallePedidoRepository extends PagingAndSortingRepository<DetallePedido, Integer> {
    
}
