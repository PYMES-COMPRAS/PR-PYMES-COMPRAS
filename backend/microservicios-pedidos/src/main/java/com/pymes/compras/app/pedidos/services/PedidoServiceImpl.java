package com.pymes.compras.app.pedidos.services;

import org.springframework.stereotype.Service;

import com.pymes.commons.models.entity.Pedido;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.pedidos.models.repository.PedidoRepository;

@Service
public class PedidoServiceImpl extends CommonServiceImpl<Pedido, PedidoRepository> implements PedidoService {
    
}
