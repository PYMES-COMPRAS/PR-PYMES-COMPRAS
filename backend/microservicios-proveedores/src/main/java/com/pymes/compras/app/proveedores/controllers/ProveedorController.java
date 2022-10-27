package com.pymes.compras.app.proveedores.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pymes.commons.controllers.CommonController;
import com.pymes.commons.proveedores.models.entity.Proveedor;
import com.pymes.compras.app.proveedores.services.ProveedorService;

@RestController
public class ProveedorController extends CommonController<Proveedor, ProveedorService>{
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Proveedor proveedor, @PathVariable Long id){
        Optional<Proveedor> o = service.findById(id);

        if(o.isEmpty()){
            ResponseEntity.notFound().build();
        }

        Proveedor proveedorDb = o.get();
        proveedorDb.setNombre(proveedor.getNombre());
        proveedorDb.setDireccion(proveedor.getDireccion());
        proveedorDb.setTelefono(proveedor.getTelefono());
        proveedorDb.setEmail(proveedor.getEmail());
        proveedorDb.setLogotipo(proveedor.getLogotipo());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proveedorDb));
    }

}
