package com.prpymes.microservicios.app.ventas.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenta; 
	

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	
	
	@Column(name = "fecha_actualizacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;
	
	
	@JsonIgnoreProperties(value = {"venta"}, allowSetters = true)
	@OneToMany(mappedBy = "venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleVenta> detallesVentas;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	
	private Long idUsuario;
	private Double total;
	private int status;
	
	public Venta() {
		this.detallesVentas = new ArrayList<>();
	}
	



	@PrePersist
	public void prePersist() {
		this.fechaActualizacion = new Date();
		this.fechaCreacion = new Date();
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
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

	public List<DetalleVenta> getDetallesVentas() {
		return detallesVentas;
	}

	public void setDetallesVentas(List<DetalleVenta> detallesVentas) {
		this.detallesVentas.clear();
		detallesVentas.forEach(this::addDetalleVenta);
	}
	public void addDetalleVenta(DetalleVenta detalleVenta)
	{
		this.detallesVentas.add(detalleVenta);
		detalleVenta.setVenta(this);
	}
	
	public void removeDetalleVenta(DetalleVenta detalleVenta)
	{
		this.detallesVentas.remove(detalleVenta);
		detalleVenta.setVenta(null);
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	




	
	
	
	
	

}
