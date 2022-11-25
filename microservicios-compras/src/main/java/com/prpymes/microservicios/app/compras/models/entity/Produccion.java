package com.prpymes.microservicios.app.compras.models.entity;

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
@Table(name = "pm_c_produccion")
public class Produccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idProduccion;

    @Column(name = "ref_produccion", length = 45)
    private String refProduccion;

    @Column(name = "fecha_produccion")
    private Date fechaProduccion;

    private Boolean estado = true;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @JsonIgnoreProperties(value = {"produccion"}, allowSetters = true)
    @OneToMany(mappedBy = "produccion", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Manufactura> manufacturas;

    @PrePersist
    public void aniadirFecha() {
        this.updateDate = new Date();
    }

    public Produccion() {
        this.manufacturas = new ArrayList<>();
    }

    public Long getIdProduccion() {
        return idProduccion;
    }
    public void setIdProduccion(Long idProduccion) {
        this.idProduccion = idProduccion;
    }
    public String getRefProduccion() {
        return refProduccion;
    }
    public void setRefProduccion(String refProduccion) {
        this.refProduccion = refProduccion;
    }
    public Date getFechaProduccion() {
        return fechaProduccion;
    }
    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<Manufactura> getManufacturas() {
        return manufacturas;
    }

    public void setManufacturas(List<Manufactura> manufacturas) {
        this.manufacturas.clear();
        manufacturas.forEach(this::addManufactura);
    }

    public void addManufactura(Manufactura manufactura) {
        this.manufacturas.add(manufactura);
        manufactura.setProduccion(this);
    }

    public void removeManufactura(Manufactura manufactura) {
        this.manufacturas.remove(manufactura);
        manufactura.setProduccion(null);
    }
    
}
