package com.pymes.compras.app.detallespedidos.services;

import org.springframework.stereotype.Service;

import com.pymes.commons.models.entity.DetallePedido;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.detallespedidos.models.repository.DetallePedidoRepository;

@Service
public class DetallePedidoServiceImpl extends CommonServiceImpl<DetallePedido, DetallePedidoRepository> implements DetallePedidoService {
    
}
