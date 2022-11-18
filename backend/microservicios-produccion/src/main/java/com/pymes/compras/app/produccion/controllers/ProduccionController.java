package com.pymes.compras.app.produccion.controllers;


import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.models.entity.Produccion;
import com.pymes.compras.app.produccion.services.ProduccionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProduccionController extends CommonController<Produccion, ProduccionService> {
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Produccion produccion, @PathVariable Integer id){
        Optional<Produccion> o = service.findById(id);

        if(!o.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Produccion produccionDb = o.get();
        produccionDb.setRefProduccion(produccion.getRefProduccion());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produccionDb));
    }


}
