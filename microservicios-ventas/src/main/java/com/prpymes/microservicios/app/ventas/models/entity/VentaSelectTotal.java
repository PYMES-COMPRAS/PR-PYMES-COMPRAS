package com.prpymes.microservicios.app.ventas.models.entity;

import java.util.Date;

import javax.persistence.Entity;

public class VentaSelectTotal {
	double total;
	Date fecha_creacion;
	
	
	public VentaSelectTotal(double total, Date fecha_creacion) {
		super();
		this.total = total;
		this.fecha_creacion = fecha_creacion;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	
}
