package com.prpymes.microservicios.app.compras.controllers;

import java.util.List;
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

import com.prpymes.microservicios.app.compras.models.entity.Presupuesto;
import com.prpymes.microservicios.app.compras.models.entity.Proveedor;
import com.prpymes.microservicios.app.compras.services.ProveedorService;
import com.prpymes.microservicios.commons.controllers.CommonControllerC;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProveedorController extends CommonControllerC<Proveedor, ProveedorService>{
    
    @PutMapping("/proveedores/{id}")
    public ResponseEntity<?> editar(@RequestBody Proveedor proveedor, @PathVariable Long id){
        Optional<Proveedor> o = service.findById(id);

        if(!o.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Proveedor proveedorDb = o.get();
        proveedorDb.setNombre(proveedor.getNombre());
        proveedorDb.setDireccion(proveedor.getDireccion());
        proveedorDb.setTelefono(proveedor.getTelefono());
        proveedorDb.setEmail(proveedor.getEmail());
        proveedorDb.setLogotipo(proveedor.getLogotipo());

        proveedorDb.getPresupuestos()
        .stream()
        .filter(pdb -> !proveedor.getPresupuestos().contains(pdb))
        .forEach(proveedorDb::removePresupuesto);

        proveedorDb.setPresupuestos(proveedor.getPresupuestos());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proveedorDb));
    }

    @GetMapping("/proveedores/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombre(term));
	}

    @GetMapping("/proveedores/filtrarPresupuesto/{idProveedor}")
    public ResponseEntity<?> filtrarPresupuestoPorProveedor(@PathVariable Long idProveedor){
        return ResponseEntity.ok(service.findPresupuestosForProvedor(idProveedor));
    }

    @PutMapping("/proveedores/delete/{id}")
    public ResponseEntity<?> deleteLogico(@RequestBody Proveedor proveedor, @PathVariable Long id){
        Optional<Proveedor> o = service.findById(id);

        if(!o.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Proveedor proveedorDb = o.get();
        proveedorDb.setEstado(proveedor.getEstado());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proveedorDb));
    }

    @PutMapping("/proveedores/{id}/agregar-presupuestos")
    public ResponseEntity<?> agregarPresupuestos(@RequestBody List<Presupuesto> presupuestos, @PathVariable Long id){
        Optional<Proveedor> o = this.service.findById(id);
        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Proveedor proveedorDb = o.get();

        presupuestos.forEach(a -> {
            proveedorDb.addPresupuesto(a);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(proveedorDb));
    }

    @PutMapping("/proveedores/{id}/eliminar-presupuesto")
    public ResponseEntity<?> eliminarPresupuesto(@RequestBody Presupuesto presupuesto, @PathVariable Long id){
        Optional<Proveedor> o = this.service.findById(id);
        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Proveedor proveedorDb = o.get();

        proveedorDb.removePresupuesto(presupuesto);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(proveedorDb));
    }

    @Override
	@GetMapping("/proveedores")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Proveedor> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(o.get());
	}

	@Override
	@GetMapping("/proveedores/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@Override
	@PostMapping("/proveedores")
	public ResponseEntity<?> crear(@RequestBody Proveedor proveedor) {
		Proveedor proveedorDb = service.save(proveedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorDb);
	}

	@Override
	@DeleteMapping("/proveedores/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
