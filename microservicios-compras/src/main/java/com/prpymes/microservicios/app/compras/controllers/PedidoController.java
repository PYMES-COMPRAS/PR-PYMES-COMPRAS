package com.prpymes.microservicios.app.compras.controllers;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.Pedido;
import com.prpymes.microservicios.app.compras.services.PedidoService;
import com.prpymes.microservicios.commons.controllers.CommonController;

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

        pedidoDb.getDetallespedidos()
        .stream()
        .filter(pdb -> !pedido.getDetallespedidos().contains(pdb))
        .forEach(pedidoDb::removeDetallePedido);

        pedidoDb.setDetallespedidos(pedidoDb.getDetallespedidos());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidoDb));
    }

    @PutMapping("/editar-pedido-para-confirmar/{id}")
    public ResponseEntity<?> editarPedido(@RequestBody Pedido pedido, @PathVariable Integer id){
        Optional<Pedido> o = service.findById(id);

        if(o.isEmpty()){
            ResponseEntity.notFound().build();
        }

        Pedido pedidoDb = o.get();

        pedidoDb.setFechaEntrega(pedido.getFechaEntrega());
        pedidoDb.setMetodoPedido(pedido.getMetodoPedido());
        pedidoDb.setNota(pedido.getNota());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidoDb));
    }


    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrarPedido(@Param("id") @PathVariable Integer id) {
        return ResponseEntity.ok(service.showPedidoById(id));
    }
    
}
