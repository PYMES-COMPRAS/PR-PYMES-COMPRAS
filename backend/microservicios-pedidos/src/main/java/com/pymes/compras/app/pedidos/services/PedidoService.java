package com.pymes.compras.app.pedidos.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pymes.commons.models.entity.Pedido;
import com.pymes.commons.services.CommonService;

public interface PedidoService extends CommonService<Pedido>{
    
    public List<Object> showPedidoById(@Param("id") Integer id);
}
