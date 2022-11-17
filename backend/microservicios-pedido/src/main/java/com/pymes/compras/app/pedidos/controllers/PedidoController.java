package com.pymes.compras.app.pedidos.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.pedidos.models.entity.Pedido;
import com.pymes.compras.app.pedidos.services.PedidoService;

@RestController
public class PedidoController extends CommonController<Pedido, PedidoService>{
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Pedido pedido, @PathVariable Long id){
        Optional<Pedido> o = service.findById(id);
        if(!o.isPresent()){
            ResponseEntity.notFound().build();
        }
//listar compras
        Pedido PedidoDB = o.get();
        PedidoDB.setIdPedido(pedido.getIdPedido());
        PedidoDB.setIdPresupuesto(pedido.getIdPresupuesto());
        PedidoDB.setIdProducto(pedido.getIdProducto());
        PedidoDB.setFecha_orden(pedido.getFecha_orden());
        PedidoDB.setCondiconnes_pago(pedido.getTipo_pago());
        PedidoDB.setTipo_pago(pedido.getTipo_pago());
        PedidoDB.setFecha_entrega(pedido.getFecha_entrega());
        PedidoDB.setNota(pedido.getNota());
        PedidoDB.setDivisa(pedido.getDivisa());
        PedidoDB.setEstado(pedido.getEstado());
        PedidoDB.setUpdate_date(pedido.getUpdate_date());
        PedidoDB.setUser_update(pedido.getUser_update());

        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(PedidoDB));
    }

    @GetMapping("/listarCompras")
    public ResponseEntity<?> listarCompras(){
        return ResponseEntity.ok().body(service.findByPassed(1));
    }

}
