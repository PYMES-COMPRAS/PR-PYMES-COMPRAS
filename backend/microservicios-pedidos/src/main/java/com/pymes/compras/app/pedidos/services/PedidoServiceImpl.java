package com.pymes.compras.app.pedidos.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pymes.commons.models.entity.Pedido;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.pedidos.models.repository.PedidoRepository;

@Service
public class PedidoServiceImpl extends CommonServiceImpl<Pedido, PedidoRepository> implements PedidoService {

    @Override
    @Transactional(readOnly = true)
    public List<Object> showPedidoById(@Param("id") Integer id) {
        return repository.showPedidoById(id);
    }
    
    
}
