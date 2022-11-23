package com.prpymes.microservicios.app.compras.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.Producto;
import com.prpymes.microservicios.app.compras.services.ProductoService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductoController extends CommonController<Producto, ProductoService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Producto producto, @PathVariable Integer id){
        Optional<Producto> o = service.findById(id);

        if(!o.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Producto productoDb = o.get();
        productoDb.setNombre(producto.getNombre());

        productoDb.getDetallespedidos()
        .stream()
        .filter(pdb -> !producto.getDetallespedidos().contains(pdb))
        .forEach(productoDb::removeDetallePedido);

        productoDb.setDetallespedidos(productoDb.getDetallespedidos());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoDb));
    }
}
