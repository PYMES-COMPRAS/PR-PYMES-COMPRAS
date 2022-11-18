package com.pymes.compras.app.manufacturas.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.models.entity.Manufactura;
import com.pymes.compras.app.manufacturas.services.ManufacturaService;

@RestController
public class ManufacturaController extends CommonController<Manufactura, ManufacturaService> {
    
}
