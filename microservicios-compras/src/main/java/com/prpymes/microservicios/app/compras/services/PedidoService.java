package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.compras.models.entity.Pedido;
import com.prpymes.microservicios.commons.services.CommonServiceC;

public interface PedidoService extends CommonServiceC<Pedido>{
    
    public List<Object> showPedidoById(@Param("id") Long id);

    public List<Object> listarPedidos();
}
