package com.prpymes.microservicios.app.librodiario.models.entity;

import javax.persistence.CascadeType;
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
	private String tipo_detalle;
	private Double monto;
	
	
	@JsonIgnoreProperties(value = {"detalles"})
	@ManyToOne(fetch = FetchType.LAZY)
	//@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_libro_diario")
    private LibroDiario libroDiario;
	
    @JoinColumn(name = "id_cuenta")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    //@ManyToOne(fetch = FetchType.LAZY)
    private Cuentas cuenta;
	
	
	public LibroDiario getLibroDiario() {
		return libroDiario;
	}
	public void setLibroDiario(LibroDiario libroDiario) {
		this.libroDiario = libroDiario;
	}
	public Cuentas getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuentas cuenta) {
		this.cuenta = cuenta;
	}
	
	public Long getId_detalle() {
		return id_detalle;
	}
	public void setId_detalle(Long id_detalle) {
		this.id_detalle = id_detalle;
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
