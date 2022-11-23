package com.prpymes.microservicios.app.compras.controllers;

import java.time.LocalDate;

import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.DetallePedido;
import com.prpymes.microservicios.app.compras.services.DetallePedidoService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class DetallePedidoController extends CommonController<DetallePedido, DetallePedidoService> {

    @GetMapping("/filtrar/fecha-total/")
	public ResponseEntity<?> filtrarByTotal(@Param("from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,@Param("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to){
		return ResponseEntity.ok(service.findByDateTotal(from, to));
	}
}
