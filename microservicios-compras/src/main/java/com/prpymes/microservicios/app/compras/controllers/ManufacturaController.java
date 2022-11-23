package com.prpymes.microservicios.app.compras.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.Manufactura;
import com.prpymes.microservicios.app.compras.services.ManufacturaService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class ManufacturaController extends CommonController<Manufactura, ManufacturaService> {
    
}
