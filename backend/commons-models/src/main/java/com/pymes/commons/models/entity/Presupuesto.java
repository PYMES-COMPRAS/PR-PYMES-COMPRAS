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
    private Integer idPresupuesto;

    @Column(name = "ref_presupuesto", length = 45)
    private String refPresupuesto;

    @Column(name = "base_imponible", precision = 8, scale = 2 )
    private BigDecimal baseImponible;

    private Short descuentos;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @Column(name = "condiciones_pago")
    private Short condicionesPago;

    @Column(name = "tipo_pago")
    private Short tipoPago;

    private Short divisa;

    @Column(name = "presupuesto_actual", precision = 8, scale = 2)
    private BigDecimal presupuestoActual;

    @Column(length = 1)
    private Boolean estado;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "user_update")
    private Integer userUpdate;

    @JsonIgnoreProperties(value = {"presupuestos","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @JsonIgnoreProperties(value = {"presupuesto"}, allowSetters = true)
    @OneToMany(mappedBy = "presupuesto", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    @PrePersist
    public void aniadirFecha() {
        this.updateDate = new Date();
    }

    public Presupuesto() {
        this.pedidos = new ArrayList<>();
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getRefPresupuesto() {
        return refPresupuesto;
    }

    public void setRefPresupuesto(String refPresupuesto) {
        this.refPresupuesto = refPresupuesto;
    }

    public BigDecimal getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }

    public Short getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Short descuentos) {
        this.descuentos = descuentos;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public Short getDivisa() {
        return divisa;
    }

    public void setDivisa(Short divisa) {
        this.divisa = divisa;
    }

    public BigDecimal getPresupuestoActual() {
        return presupuestoActual;
    }

    public void setPresupuestoActual(BigDecimal presupuestoActual) {
        this.presupuestoActual = presupuestoActual;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Presupuesto)) {
            return false;
        }
        Presupuesto p = (Presupuesto) obj;

        return this.idPresupuesto != null && this.idPresupuesto.equals(p.getIdPresupuesto());
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos.clear();
        pedidos.forEach(this::addPedido);
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        pedido.setPresupuesto(this);
    }
    
    public void removePedido(Pedido pedido) {
        this.pedidos.remove(pedido);
        pedido.setPresupuesto(null);
    }
    
}
