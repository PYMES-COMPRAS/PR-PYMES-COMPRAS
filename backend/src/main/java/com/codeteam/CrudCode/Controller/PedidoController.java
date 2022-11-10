/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeteam.CrudCode.Controller;

import com.codeteam.CrudCode.Model.Pedido;
import com.codeteam.CrudCode.Service.PedidoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yonder
 */
@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/api")
public class PedidoController {
	
	  @Autowired
	    private PedidoService tareaService;
	    
	    //listar
	    @GetMapping("/pedidos")
	    public List<Pedido> listar()
	    {
	        return tareaService.findAll();
	    }
	    
	    //guardar
	    @PostMapping("/pedidos")
	    public  Pedido guardar(@RequestBody Pedido tarea)
	    {
	        return tareaService.save(tarea);
	    }
	    
	    //get una tarea
	    @GetMapping("/pedidos/{id}")
	    public Pedido getUnaTarea(@PathVariable Integer id)
	    {
	        return tareaService.findById(id);
	    }
	    
	    //Modeficar
	    @PutMapping("/pedidos/{id}")
	    public Pedido modifecar(@RequestBody Pedido tarea,@PathVariable Integer id)
	    {
	    	Pedido tareaActual= tareaService.findById(id);
	        tareaActual.setFecha_orden(tarea.getFecha_orden());
	        tareaActual.setNota(tarea.getNota());
	        tareaActual.setEstado(tarea.getEstado());
	      //  tareaActual.setFinalizado(tarea.getFinalizado());
	        
	        return tareaService.save(tareaActual);
	    }
	    
	    @DeleteMapping("/pedidos/{id}")
	    public void eliminar(@PathVariable Integer id)
	    {
	        tareaService.delete(id);
	    }
	
	
    
}
