package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.compras.models.entity.Pedido;
import com.prpymes.microservicios.commons.services.CommonService;

public interface PedidoService extends CommonService<Pedido>{
    
    public List<Object> showPedidoById(@Param("id") Integer id);
}
