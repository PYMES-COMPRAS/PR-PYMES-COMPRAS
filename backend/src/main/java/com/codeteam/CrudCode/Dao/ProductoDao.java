/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.codeteam.CrudCode.Dao;

import com.codeteam.CrudCode.Model.Producto;

import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author yonder
 */

public interface ProductoDao extends CrudRepository<Producto, Integer>{
	

    
}
