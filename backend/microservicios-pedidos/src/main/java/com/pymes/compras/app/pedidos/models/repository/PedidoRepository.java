package com.pymes.compras.app.pedidos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.pymes.commons.models.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
    
}
