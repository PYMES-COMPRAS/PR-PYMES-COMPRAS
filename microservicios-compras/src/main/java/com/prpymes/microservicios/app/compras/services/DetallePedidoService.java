package com.prpymes.microservicios.app.compras.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.compras.models.entity.DetallePedido;
import com.prpymes.microservicios.commons.services.CommonServiceC;

public interface DetallePedidoService extends CommonServiceC<DetallePedido>{
    
    public List<Object> findByDateTotal(@Param("from") LocalDate from,@Param("to") LocalDate to);
}


