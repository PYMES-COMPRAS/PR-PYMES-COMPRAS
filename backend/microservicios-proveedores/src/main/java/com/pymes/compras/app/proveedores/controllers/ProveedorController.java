package com.pymes.compras.app.proveedores.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.models.entity.Presupuesto;
import com.pymes.commons.models.entity.Proveedor;
import com.pymes.compras.app.proveedores.services.ProveedorService;

@RestController
public class ProveedorController extends CommonController<Proveedor, ProveedorService>{
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Proveedor proveedor, @PathVariable Integer id){
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
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proveedorDb));
    }

    @PutMapping("/{id}/agregar-presupuestos")
    public ResponseEntity<?> agregarPresupuestos(@RequestBody List<Presupuesto> presupuestos, @PathVariable Integer id){
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

    @PutMapping("/{id}/eliminar-presupuesto")
    public ResponseEntity<?> eliminarPresupuesto(@RequestBody Presupuesto presupuesto, @PathVariable Integer id){
        Optional<Proveedor> o = this.service.findById(id);
        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Proveedor proveedorDb = o.get();

        proveedorDb.removePresupuesto(presupuesto);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(proveedorDb));
    }

}
