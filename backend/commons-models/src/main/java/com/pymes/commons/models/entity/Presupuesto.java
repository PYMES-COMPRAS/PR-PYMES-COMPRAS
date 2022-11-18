package com.pymes.commons.models.entity;

import java.math.BigDecimal;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pm_c_presupuesto")
public class Presupuesto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "idProveedor")
    private  Integer idProveedor;

    @Column(name = "ref_presupuesto", length = 45)
    private String refPresupuesto;

    @Column(name = "base_imponible", precision = 8, scale = 2 )
    private BigDecimal baseImponible;

    @Column(name = "descuentos")
    private Short descuentos;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "presupuesto_actual", precision = 8, scale = 2)
    private BigDecimal presupuestoActual;

    @Column(length = 1)
    private int estado;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "user_update")
    private Integer userUpdate;

    
    /*@JsonIgnoreProperties(value = {"presupuestos"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @JsonIgnoreProperties(value = {"presupuesto"}, allowSetters = true)
    @OneToMany(mappedBy = "presupuesto", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;*/


    public Presupuesto() {
    }

    public Presupuesto(Integer id, Integer idProveedor, String refPresupuesto, BigDecimal baseImponible, Short descuentos, Date fechaInicio, BigDecimal presupuestoActual, int estado, Date updateDate, Integer userUpdate) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.refPresupuesto = refPresupuesto;
        this.baseImponible = baseImponible;
        this.descuentos = descuentos;
        this.fechaInicio = fechaInicio;
        this.presupuestoActual = presupuestoActual;
        this.estado = estado;
        this.updateDate = updateDate;
        this.userUpdate = userUpdate;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProveedor() {
        return this.idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRefPresupuesto() {
        return this.refPresupuesto;
    }

    public void setRefPresupuesto(String refPresupuesto) {
        this.refPresupuesto = refPresupuesto;
    }

    public BigDecimal getBaseImponible() {
        return this.baseImponible;
    }

    public void setBaseImponible(BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }

    public Short getDescuentos() {
        return this.descuentos;
    }

    public void setDescuentos(Short descuentos) {
        this.descuentos = descuentos;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public BigDecimal getPresupuestoActual() {
        return this.presupuestoActual;
    }

    public void setPresupuestoActual(BigDecimal presupuestoActual) {
        this.presupuestoActual = presupuestoActual;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUserUpdate() {
        return this.userUpdate;
    }

    public void setUserUpdate(Integer userUpdate) {
        this.userUpdate = userUpdate;
    }

    public Presupuesto id(Integer id) {
        setId(id);
        return this;
    }

    public Presupuesto idProveedor(Integer idProveedor) {
        setIdProveedor(idProveedor);
        return this;
    }

    public Presupuesto refPresupuesto(String refPresupuesto) {
        setRefPresupuesto(refPresupuesto);
        return this;
    }

    public Presupuesto baseImponible(BigDecimal baseImponible) {
        setBaseImponible(baseImponible);
        return this;
    }

    public Presupuesto descuentos(Short descuentos) {
        setDescuentos(descuentos);
        return this;
    }

    public Presupuesto fechaInicio(Date fechaInicio) {
        setFechaInicio(fechaInicio);
        return this;
    }

    public Presupuesto presupuestoActual(BigDecimal presupuestoActual) {
        setPresupuestoActual(presupuestoActual);
        return this;
    }

    public Presupuesto estado(int estado) {
        setEstado(estado);
        return this;
    }

    public Presupuesto updateDate(Date updateDate) {
        setUpdateDate(updateDate);
        return this;
    }

    public Presupuesto userUpdate(Integer userUpdate) {
        setUserUpdate(userUpdate);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idProveedor='" + getIdProveedor() + "'" +
            ", refPresupuesto='" + getRefPresupuesto() + "'" +
            ", baseImponible='" + getBaseImponible() + "'" +
            ", descuentos='" + getDescuentos() + "'" +
            ", fechaInicio='" + getFechaInicio() + "'" +
            ", presupuestoActual='" + getPresupuestoActual() + "'" +
            ", estado='" + getEstado() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", userUpdate='" + getUserUpdate() + "'" +
            "}";
    }
    
}
