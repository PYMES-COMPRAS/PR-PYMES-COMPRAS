package com.pymes.compras.app.detallespedidos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.pymes.commons.models.entity.DetallePedido;

public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Integer> {
    
}
