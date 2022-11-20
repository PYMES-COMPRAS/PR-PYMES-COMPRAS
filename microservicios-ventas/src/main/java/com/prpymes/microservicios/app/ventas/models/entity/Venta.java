package com.prpymes.microservicios.app.ventas.models.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sale")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSale;
	
	private Long idEmployee;
	private int status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;
	
	private Long idClient;
	
	@PrePersist
	public void prePersist()
	{
		this.registrationDate = new Date();
		this.dateUpdate = new Date();
	}
	
	
	public Long getIdSale() {
		return idSale;
	}
	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}
	public Long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	
	
	
	
	
}
