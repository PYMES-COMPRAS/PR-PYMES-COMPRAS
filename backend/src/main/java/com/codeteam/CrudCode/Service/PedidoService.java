/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.codeteam.CrudCode.Service;

import com.codeteam.CrudCode.Model.Pedido;
import java.util.List;

/**
 *
 * @author yonder
 */
public interface PedidoService {
    public List<Pedido> findAll();
    public Pedido save(Pedido pedido);
    public Pedido findById(Integer id);
    public void delete(Integer id);
    
}
