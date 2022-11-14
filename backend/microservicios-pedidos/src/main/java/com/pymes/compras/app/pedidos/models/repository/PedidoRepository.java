package com.pymes.compras.app.pedidos.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pymes.commons.models.entity.Pedido;

public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Integer> {
    
}
