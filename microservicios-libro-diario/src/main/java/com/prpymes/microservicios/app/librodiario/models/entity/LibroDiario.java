package com.prpymes.microservicios.app.librodiario.models.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="libro_diario")
public class LibroDiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String glosa;
	private String razon_social;
	private String tipo_libro;
	
	@JsonIgnoreProperties(value = {"libroDiario"}, allowSetters = true)
	@OneToMany(mappedBy = "libroDiario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleLibroDiario> detalles;	
	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	public LibroDiario() {
		this.detalles=new ArrayList<>();
	}
	
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGlosa() {
		return glosa;
	}
	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getTipo_libro() {
		return tipo_libro;
	}
	public void setTipo_libro(String tipo_libro) {
		this.tipo_libro = tipo_libro;
	} 	
	public List<DetalleLibroDiario> getDetalles() {
		return detalles;
	}	
}
