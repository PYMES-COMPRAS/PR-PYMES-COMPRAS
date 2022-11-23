package com.prpymes.microservicios.app.compras.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.Pedido;
import com.prpymes.microservicios.app.compras.models.entity.Presupuesto;
import com.prpymes.microservicios.app.compras.services.PresupuestoService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class PresupuestoController extends CommonController<Presupuesto, PresupuestoService> {
    
    @PutMapping("/presupuestos/{id}")
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

        presupuestoDb.getPedidos()
        .stream()
        .filter(pdb -> !presupuesto.getPedidos().contains(pdb))
        .forEach(presupuestoDb::removePedido);

        presupuestoDb.setPedidos(presupuestoDb.getPedidos());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(presupuestoDb));
    }

    
    @PutMapping("/presupuestos/{id}/agregar-pedido")
    public ResponseEntity<?> agregarPedido(@RequestBody List<Pedido> pedidos, @PathVariable Integer id){
        Optional<Presupuesto> o = this.service.findById(id);
        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Presupuesto presupuestoDb = o.get();

        pedidos.forEach(a -> {
            presupuestoDb.addPedido(a);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(presupuestoDb));
    }

    @PutMapping("/presupuestos/{id}/eliminar-pedido")
    public ResponseEntity<?> eliminarPedido(@RequestBody Pedido pedido, @PathVariable Integer id){
        Optional<Presupuesto> o = this.service.findById(id);
        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Presupuesto presupuestoDb = o.get();

        presupuestoDb.removePedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(presupuestoDb));
    }

    @GetMapping("/presupuestos/proveedor")
    public ResponseEntity<?> presupuestsProveedor(){
        return ResponseEntity.ok(service.joinPresupuestoWithProveedor());
    }

    @Override
	@GetMapping("/presupuestos/")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/presupuestos/{id}")
	public ResponseEntity<?> ver(@PathVariable Integer id) {
		Optional<Presupuesto> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(o.get());
	}

	@Override
	@GetMapping("/presupuestos/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@Override
	@PostMapping("/presupuestos/")
	public ResponseEntity<?> crear(@RequestBody Presupuesto presupuesto) {
		Presupuesto presupuestoDb = service.save(presupuesto);
		return ResponseEntity.status(HttpStatus.CREATED).body(presupuestoDb);
	}

	@Override
	@DeleteMapping("/presupuestos/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
