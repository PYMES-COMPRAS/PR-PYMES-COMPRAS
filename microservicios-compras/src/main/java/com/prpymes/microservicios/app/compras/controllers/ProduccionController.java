package com.prpymes.microservicios.app.compras.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.Produccion;
import com.prpymes.microservicios.app.compras.services.ProduccionService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class ProduccionController extends CommonController<Produccion, ProduccionService> {
    
}
