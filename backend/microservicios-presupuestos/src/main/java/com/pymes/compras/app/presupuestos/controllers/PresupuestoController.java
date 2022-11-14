package com.pymes.compras.app.presupuestos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.models.entity.Pedido;
import com.pymes.commons.models.entity.Presupuesto;
import com.pymes.compras.app.presupuestos.services.PresupuestoService;

@RestController
public class PresupuestoController extends CommonController<Presupuesto, PresupuestoService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Presupuesto presupuesto, @PathVariable Integer id){
        Optional<Presupuesto> o = service.findById(id);

        if(o.isEmpty()){
            ResponseEntity.notFound().build();
        }

        Presupuesto presupuestoDb = o.get();
        presupuestoDb.setRefPresupuesto(presupuesto.getRefPresupuesto());
        presupuestoDb.setBaseImponible(presupuesto.getBaseImponible());
        presupuestoDb.setDescuentos(presupuesto.getDescuentos());
        presupuestoDb.setFechaInicio(presupuesto.getFechaInicio());
        presupuestoDb.setPresupuestoActual(presupuesto.getPresupuestoActual());
        presupuestoDb.setEstado(presupuesto.getEstado());
        presupuestoDb.setUserUpdate(presupuesto.getUserUpdate());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(presupuestoDb));
    }

    
    @PutMapping("/{id}/agregar-pedido")
    public ResponseEntity<?> agregarPedido(@RequestBody List<Pedido> pedidos, @PathVariable Integer id){
        Optional<Presupuesto> o = this.service.findById(id);
        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Presupuesto presupuestoDb = o.get();

        pedidos.forEach(a -> {
           // presupuestoDb.addPedido(a);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(presupuestoDb));
    }

    @PutMapping("/{id}/eliminar-pedido")
    public ResponseEntity<?> eliminarPedido(@RequestBody Pedido pedido, @PathVariable Integer id){
        Optional<Presupuesto> o = this.service.findById(id);
        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Presupuesto presupuestoDb = o.get();

        //presupuestoDb.removePedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(presupuestoDb));
    }

    @GetMapping("/proveedor")
    public ResponseEntity<?> presupuestsProveedor(){
        return ResponseEntity.ok(service.joinPresupuestoWithProveedor());
    }

}
