/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeteam.CrudCode.Controller;

import com.codeteam.CrudCode.Model.Producto;

import com.codeteam.CrudCode.Service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yonder
 */
@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private ProductoService tareaService;
    
    //listar
    @GetMapping("/producto")
    public List<Producto> listar()
    {
        return tareaService.findAll();
    }
    

    //get una tarea
    @GetMapping("/productos/{id}")
    public Producto getUnaTarea(@PathVariable Integer id)
    {
        return tareaService.findById(id);
    }
   
    
   /* @GetMapping("/produc")
    private String product(Model model) {
    	model.addAttribute("nombre", new Producto());
    	return "product";
    }	
    @GetMapping("/products")
    private String buscarPorNombre(@RequestParam String nombre,Model model, @ModelAttribute("nombre") Producto producto) {
   model.addAttribute("nombre", tareaService.busquedaName(nombre));
    return "product";	
    }
   */
    
}
