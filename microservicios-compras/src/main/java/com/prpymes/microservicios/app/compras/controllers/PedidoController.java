package com.prpymes.microservicios.app.compras.controllers;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
import com.prpymes.microservicios.app.compras.services.PedidoService;
import com.prpymes.microservicios.commons.controllers.CommonControllerC;

@RestController
public class PedidoController extends CommonControllerC<Pedido, PedidoService> {
    
    @PutMapping("/pedidos/{id}")
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

    @PutMapping("/pedidos/editar-pedido-para-confirmar/{id}")
    public ResponseEntity<?> editarPedido(@RequestBody Pedido pedido, @PathVariable Integer id){
        Optional<Pedido> o = service.findById(id);

        if(o.isEmpty()){
            ResponseEntity.notFound().build();
        }

        Pedido pedidoDb = o.get();

        pedidoDb.setFechaEntrega(pedido.getFechaEntrega());
        pedidoDb.setMetodoPedido(pedido.getMetodoPedido());
        pedidoDb.setNota(pedido.getNota());
        pedidoDb.setEstado((short) 2);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidoDb));
    }


    @GetMapping("/pedidos/mostrar/{id}")
    public ResponseEntity<?> mostrarPedido(@Param("id") @PathVariable Integer id) {
        return ResponseEntity.ok(service.showPedidoById(id));
    }
    
    @Override
	@GetMapping("/pedidos")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<?> ver(@PathVariable Integer id) {
		Optional<Pedido> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(o.get());
	}

	@Override
	@GetMapping("/pedidos/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@Override
	@PostMapping("/pedidos")
	public ResponseEntity<?> crear(@RequestBody Pedido pedido) {
		Pedido pedidoDb = service.save(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDb);
	}

	@Override
	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

    @GetMapping("/pedidos/listaPedidos")
	public ResponseEntity<?> listadoPedidos() {
		return ResponseEntity.ok(service.listarPedidos());
	}
}
