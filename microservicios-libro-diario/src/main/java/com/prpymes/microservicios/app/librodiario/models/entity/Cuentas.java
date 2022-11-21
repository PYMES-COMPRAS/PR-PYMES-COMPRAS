package com.prpymes.microservicios.app.librodiario.models.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Cuenta")
public class Cuentas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuenta;
	
	private String denominacion;
	private String codigoCuenta;
	private Long idEmpresa;
	private int status;	
	
	@OneToMany(mappedBy = "cuenta", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<DetalleLibroDiario> detalles;
	
	@PrePersist 
	public void prePersist() {
	this.status = 1;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}	
	
}
