package com.pymes.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pymes.commons.services.CommonService;

@CrossOrigin({"http://localhost:4200"})
public class CommonController<E, S extends CommonService<E>> {
    
    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Integer id){
        Optional<E> o = service.findById(id);
        if(o.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody E entity){
        E entityDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    } 
}
