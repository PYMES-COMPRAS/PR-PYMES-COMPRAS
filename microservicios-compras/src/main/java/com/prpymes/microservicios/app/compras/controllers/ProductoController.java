package com.prpymes.microservicios.app.compras.controllers;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.compras.models.entity.Producto;
import com.prpymes.microservicios.app.compras.services.ProductoService;
import com.prpymes.microservicios.commons.controllers.CommonControllerC;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductoController extends CommonControllerC<Producto, ProductoService> {
    
    @PutMapping("/productos/{id}")
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

    @Override
	@GetMapping("/productos")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> ver(@PathVariable Integer id) {
		Optional<Producto> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(o.get());
	}

	@Override
	@GetMapping("/productos/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@Override
	@PostMapping("/productos")
	public ResponseEntity<?> crear(@RequestBody Producto producto) {
		Producto productoDb = service.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDb);
	}

	@Override
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
