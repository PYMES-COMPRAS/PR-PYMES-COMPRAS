package com.pymes.compras.app.pedidos.services;

import java.util.List;
import com.pymes.commons.pedidos.models.entity.Pedido;
import com.pymes.commons.services.CommonService;
public interface PedidoService extends CommonService<Pedido>{
    public List<Pedido> findByPassed(Integer estadoAprobado);

    
}




