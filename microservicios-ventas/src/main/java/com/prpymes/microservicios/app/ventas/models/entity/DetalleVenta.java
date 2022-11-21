package com.prpymes.microservicios.app.ventas.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleVenta; 
	
	
	@Column(name = "precio_venta")
	private Double precioVenta;

	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	
	
	@Column(name = "fecha_actualizacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;
	
	@JsonIgnoreProperties(value = {"detalles_ventas"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVenta")
	private Venta venta;
	
	
	private int cantidad;
	private Long subTotal;
	private Double descuento;
	private Long idProducto;
	private int status;
	
	@PrePersist
	public void prePersist() {
		this.fechaActualizacion = new Date();
		this.fechaCreacion = new Date();
		this.descuento = 0.0;
	}

	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Long getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Long subTotal) {
		this.subTotal = subTotal;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
		{
			return true;
		}
		
		if(!(obj instanceof DetalleVenta))
		{
			return false;
		}
		
		DetalleVenta d = (DetalleVenta) obj;
		return this.idDetalleVenta != null && this.idDetalleVenta.equals(d.getIdDetalleVenta());
	}


	
	
}
