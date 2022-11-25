package com.pymes.compras.app.detallespedidos.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pymes.commons.models.entity.DetallePedido;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.detallespedidos.models.repository.DetallePedidoRepository;

@Service
public class DetallePedidoServiceImpl extends CommonServiceImpl<DetallePedido, DetallePedidoRepository> implements DetallePedidoService {
    
    //metodo para libro diario
    @Override
    @Transactional(readOnly = true)
    public List<Object> findByDateTotal(@Param("from") LocalDate from,@Param("to") LocalDate to) {
        return repository.findByDateTotal(from, to);
    }

}
