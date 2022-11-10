/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeteam.CrudCode.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author yonder
 */
@Entity
@Table(name="pm_c_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
	
	
	@Column(name="fecha_orden")
    private Date fecha_orden;
	
	@Column(name="nota")
    private String nota;
	
	public Integer getIdPedido() {
		return id;
	}

	public void setIdPedido(Integer idPedido) {
		this.id = idPedido;
	}

	public Date getFecha_orden() {
		return fecha_orden;
	}

	public void setFecha_orden(Date fecha_orden) {
		this.fecha_orden = fecha_orden;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Column(name="estado")
    private Boolean estado;

	
	
	
   /* private Integer Id;
    
    @Column(name="Tarea")
    private String Tarea;
    */
  /*  @Column(name="Finalizado")
    private Boolean Finalizado;
*/
   /* public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTarea() {
        return Tarea;
    }

    public void setTarea(String Tarea) {
        this.Tarea = Tarea;
    }*/

  /* public Boolean getFinalizado() {
        return Finalizado;
    }

    public void setFinalizado(Boolean Finalizado) {
        this.Finalizado = Finalizado;
    }
    */
}
