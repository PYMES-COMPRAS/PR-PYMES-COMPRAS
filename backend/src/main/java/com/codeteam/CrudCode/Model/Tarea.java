/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeteam.CrudCode.Model;

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
@Table(name="pm_c_presupuesto")
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;
	
	
	@Column(name="ref_presupuesto")
    private String ref_presupuesto;
	
	@Column(name="base_imponible")
    private Integer base_imponible;
	
	@Column(name="estado")
    private Boolean estado;

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getRef_presupuesto() {
		return ref_presupuesto;
	}

	public void setRef_presupuesto(String ref_presupuesto) {
		this.ref_presupuesto = ref_presupuesto;
	}

	public Integer getBase_imponible() {
		return base_imponible;
	}

	public void setBase_imponible(Integer base_imponible) {
		this.base_imponible = base_imponible;
	}
	
	
	
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
