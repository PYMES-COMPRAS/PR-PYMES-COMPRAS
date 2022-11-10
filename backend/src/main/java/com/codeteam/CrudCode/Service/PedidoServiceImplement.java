/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Dao.PedidoDao;
//import com.codeteam.CrudCode.Dao.ProductoDao1;
import com.codeteam.CrudCode.Model.Pedido;
import com.codeteam.CrudCode.Model.Tarea;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yonder
 */
@Service
public class PedidoServiceImplement  implements PedidoService{
    @Autowired
    private PedidoDao pedidoDao;
   // private ProductoDao1 productoDao1;
    @Override
    @Transactional(readOnly=true)
    public List<Pedido> findAll()
    {
        return (List<Pedido>) pedidoDao.findAll();
    }
    
    @Override
     @Transactional(readOnly=false)
    public Pedido save(Pedido pedido)
    {
        return pedidoDao.save(pedido);
    }
    
    @Override
     @Transactional(readOnly=true)
    public Pedido findById(Integer id)
    {
        return pedidoDao.findById(id).orElse(null);
    }
    
    @Override
     @Transactional(readOnly=false)
    public void delete(Integer id)
    {
    	pedidoDao.deleteById(id);
    }
    
   
    
}
