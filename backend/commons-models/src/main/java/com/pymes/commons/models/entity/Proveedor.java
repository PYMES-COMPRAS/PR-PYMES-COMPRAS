package com.pymes.commons.models.entity;

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
@Table(name="pm_c_proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String nombre;

    @Column(length = 65)
    private String direccion;

    @Column(length = 15)
    private String telefono;

    @Column(length = 125)
    private String email;

    @Column(length = 255)
    private String logotipo;

    @Column(length = 1)
    private Boolean estado;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "user_update")
    private Integer userUpdate;

    @PrePersist
    public void aniadirFecha() {
        this.updatedDate = new Date();
    }

    public Proveedor() {
        
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(Integer userUpdate) {
        this.userUpdate = userUpdate;
    }

}
