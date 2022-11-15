package com.pymes.commons.models.entity;


import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "pm_c_pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column(name = "fecha_orden")
    private Date fechaOrden;

    @Column(name = "condiciones_pago")
    private Short condicionesPago;

    @Column(name = "tipo_pago")
    private Short tipoPago;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @Column(length = 255)
    private String nota;

    private Short divisa;

    @Column(length = 1)
    private Boolean estado;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "user_update")
    private Integer userUpdate;

    @PrePersist
    public void aniadirFecha() {
        this.updateDate = new Date();
    }

    @JsonIgnoreProperties(value = {"pedidos"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPresupuesto")
    private Presupuesto presupuesto;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Short getCondicionesPago() {
        return condicionesPago;
    }

    public void setCondicionesPago(Short condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    public Short getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Short tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Short getDivisa() {
        return divisa;
    }

    public void setDivisa(Short divisa) {
        this.divisa = divisa;
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

    public Integer getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(Integer userUpdate) {
        this.userUpdate = userUpdate;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Pedido)) {
            return false;
        }
        Pedido p = (Pedido) obj;

        return this.idPedido != null && this.idPedido.equals(p.getIdPedido());
    }
    
}
