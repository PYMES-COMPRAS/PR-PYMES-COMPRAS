package com.pymes.compras.app.detallespedidos.controllers;

import java.time.LocalDate;

import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.models.entity.DetallePedido;
import com.pymes.compras.app.detallespedidos.services.DetallePedidoService;

@RestController
public class DetallePedidoController extends CommonController<DetallePedido, DetallePedidoService> {
    
    //Metodo y ruta para libro diario
    @GetMapping("/detalle-pedidos/filtrar/fecha-total/")
	public ResponseEntity<?> filtrarByTotal(@Param("from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,@Param("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to){
		return ResponseEntity.ok(service.findByDateTotal(from, to));
	}
    
}
