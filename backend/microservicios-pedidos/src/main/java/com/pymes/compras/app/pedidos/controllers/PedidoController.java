package com.pymes.compras.app.pedidos.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.models.entity.Pedido;
import com.pymes.compras.app.pedidos.services.PedidoService;

@RestController
public class PedidoController extends CommonController<Pedido, PedidoService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Pedido pedido, @PathVariable Integer id){
        Optional<Pedido> o = service.findById(id);

        if(!o.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Pedido pedidoDb = o.get();
        pedidoDb.setFechaOrden(pedido.getFechaEntrega());
        pedidoDb.setCondicionesPago(pedido.getCondicionesPago());
        pedidoDb.setTipoPago(pedido.getTipoPago());
        pedidoDb.setFechaEntrega(pedido.getFechaEntrega());
        pedidoDb.setNota(pedido.getNota());
        pedidoDb.setDivisa(pedido.getDivisa());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidoDb));
    }

}
