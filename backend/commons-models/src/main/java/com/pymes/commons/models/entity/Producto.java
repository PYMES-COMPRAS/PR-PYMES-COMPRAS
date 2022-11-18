package com.pymes.commons.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pm_b_producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nombre;

    @JsonIgnoreProperties(value = {"producto"}, allowSetters = true)
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallespedidos;

    @JsonIgnoreProperties(value = {"producto"}, allowSetters = true)
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Manufactura> manufacturas;

    public Producto() {
        this.detallespedidos = new ArrayList<>();
        this.manufacturas = new ArrayList<>();
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DetallePedido> getDetallespedidos() {
        return detallespedidos;
    }

    public void setDetallespedidos(List<DetallePedido> detallespedidos) {
        this.detallespedidos.clear();
        detallespedidos.forEach(this::addDetallepedido);
    }

    public void addDetallepedido(DetallePedido detallePedido) {
        this.detallespedidos.add(detallePedido);
        detallePedido.setProducto(this);
    }

    public void removeDetallePedido(DetallePedido detallePedido) {
        this.detallespedidos.remove(detallePedido);
        detallePedido.setProducto(null);
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
        manufactura.setProducto(this);
    }

    public void removeManufactura(Manufactura manufactura) {
        this.manufacturas.remove(manufactura);
        manufactura.setProducto(null);
    }
}
