package com.prpymes.microservicios.app.compras.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.compras.models.entity.DetallePedido;
import com.prpymes.microservicios.app.compras.models.repository.DetallePedidoRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class DetallePedidoServiceImpl extends CommonServiceImpl<DetallePedido, DetallePedidoRepository> implements DetallePedidoService {

    @Override
    @Transactional(readOnly = true)
    public List<Object> findByDateTotal(@Param("from") LocalDate from,@Param("to") LocalDate to) {
        return repository.findByDateTotal(from, to);
    }

    

}
