package com.pymes.compras.app.producciones.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.models.entity.Produccion;
import com.pymes.compras.app.producciones.services.ProduccionService;

@RestController
public class ProduccionController extends CommonController<Produccion, ProduccionService> {
    
}
