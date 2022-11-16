package com.prpymes.microservicios.app.librodiario.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detalle_libro_diario")
public class DetalleLibroDiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalle;	
	private Long id_cuenta;
	private String tipo_detalle;
	private Double monto;
	
	
	@JsonIgnoreProperties(value = {"detalles"})
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro_diario")
    private LibroDiario libroDiario;
	
	
	public LibroDiario getLibroDiario() {
		return libroDiario;
	}
	public void setLibroDiario(LibroDiario libroDiario) {
		this.libroDiario = libroDiario;
	}
	
	public Long getId_detalle() {
		return id_detalle;
	}
	public void setId_detalle(Long id_detalle) {
		this.id_detalle = id_detalle;
	}
	public Long getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(Long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public String getTipo_detalle() {
		return tipo_detalle;
	}
	public void setTipo_detalle(String tipo_detalle) {
		this.tipo_detalle = tipo_detalle;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
}
