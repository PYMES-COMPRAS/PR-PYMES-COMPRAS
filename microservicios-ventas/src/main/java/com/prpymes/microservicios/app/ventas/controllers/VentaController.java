package com.prpymes.microservicios.app.ventas.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.services.VentaService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class VentaController extends CommonController<Venta, VentaService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Venta venta, @PathVariable Long id){
		Optional<Venta> v = service.findById(id);
		if(v.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		Venta ventaDb = v.get();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ventaDb));
		
	}
	
	@GetMapping("/venta/mostrar")
	public ResponseEntity<?> filtrar(@RequestParam("fecha_inicio") String fecha_inicio, @RequestParam("fecha_fin") String fecha_fin)
	{
		return ResponseEntity .ok(service.findTotalSalesDate(fecha_inicio, fecha_fin));
	}
}
