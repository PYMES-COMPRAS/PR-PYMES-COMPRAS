package com.prpymes.microservicios.app.compras.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.compras.models.entity.Pedido;
import com.prpymes.microservicios.app.compras.models.repository.PedidoRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImplC;

@Service
public class PedidoServiceImpl extends CommonServiceImplC<Pedido, PedidoRepository> implements PedidoService {

    @Override
    @Transactional(readOnly = true)
    public List<Object> showPedidoById(@Param("id") Integer id) {
        return repository.showPedidoById(id);
    }
    
    
}
