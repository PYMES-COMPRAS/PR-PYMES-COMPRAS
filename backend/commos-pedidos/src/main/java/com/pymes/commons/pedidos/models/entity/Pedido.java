package com.pymes.commons.pedidos.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@Table(name = "PM_C_Pedido")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    private Long idPresupuesto;
    private Long idProducto;
    private Date fecha_orden;
    private Date fecha_entrega;
    private byte condiconnes_pago;
    private byte tipo_pago;
    private String nota;
    private byte divisa;
    private int estado;
    private Date update_date;
    private Long user_update;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Long idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public byte getCondiconnes_pago() {
        return condiconnes_pago;
    }

    public void setCondiconnes_pago(byte condiconnes_pago) {
        this.condiconnes_pago = condiconnes_pago;
    }

    public byte getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(byte tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public byte getDivisa() {
        return divisa;
    }

    public void setDivisa(byte divisa) {
        this.divisa = divisa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Long getUser_update() {
        return user_update;
    }
//prueba
    public void setUser_update(Long user_update) {
        this.user_update = user_update;
    }


}
