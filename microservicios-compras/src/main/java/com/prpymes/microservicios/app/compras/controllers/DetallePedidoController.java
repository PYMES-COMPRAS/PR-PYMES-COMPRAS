package com.prpymes.microservicios.app.compras.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.DetallePedido;
import com.prpymes.microservicios.app.compras.services.DetallePedidoService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class DetallePedidoController extends CommonController<DetallePedido, DetallePedidoService> {

    @GetMapping("/detalle-pedidos/filtrar/fecha-total/")
	public ResponseEntity<?> filtrarByTotal(@Param("from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,@Param("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to){
		return ResponseEntity.ok(service.findByDateTotal(from, to));
	}

	@Override
	@GetMapping("/detalle-pedidos/")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/detalle-pedidos/{id}")
	public ResponseEntity<?> ver(@PathVariable Integer id) {
		Optional<DetallePedido> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(o.get());
	}

	@Override
	@GetMapping("/detalle-pedidos/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@Override
	@PostMapping("/detalle-pedidos/")
	public ResponseEntity<?> crear(@RequestBody DetallePedido detallepedido) {
		DetallePedido detallepedidoDb = service.save(detallepedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(detallepedidoDb);
	}

	@Override
	@DeleteMapping("/detalle-pedidos/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
