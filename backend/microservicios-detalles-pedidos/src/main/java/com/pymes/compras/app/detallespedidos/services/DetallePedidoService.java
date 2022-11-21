package com.pymes.compras.app.detallespedidos.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pymes.commons.models.entity.DetallePedido;
import com.pymes.commons.services.CommonService;

public interface DetallePedidoService extends CommonService<DetallePedido>{
    
    public List<Object> findByDateTotal(@Param("from") LocalDate from,@Param("to") LocalDate to);
}
