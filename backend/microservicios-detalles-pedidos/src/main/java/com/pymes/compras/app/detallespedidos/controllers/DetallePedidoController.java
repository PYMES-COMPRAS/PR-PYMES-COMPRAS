package com.pymes.compras.app.detallespedidos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.models.entity.DetallePedido;
import com.pymes.compras.app.detallespedidos.services.DetallePedidoService;

@RestController
public class DetallePedidoController extends CommonController<DetallePedido, DetallePedidoService> {
    
}
