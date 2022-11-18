package com.pymes.commons.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="pm_c_produccion")
public class Produccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "ref_produccion", length = 1)
    public String refProduccion;

    @Column(name = "fecha_producción",length = 1)
    public Date fechaProducción;

    @Column(name = "estado",length = 1)
    private int estado;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "user_update")
    private Integer userUpdate;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefProduccion() {
        return this.refProduccion;
    }

    public void setRefProduccion(String refProduccion) {
        this.refProduccion = refProduccion;
    }

    public Date getFechaProducción() {
        return this.fechaProducción;
    }

    public void setFechaProducción(Date fechaProducción) {
        this.fechaProducción = fechaProducción;
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

}
