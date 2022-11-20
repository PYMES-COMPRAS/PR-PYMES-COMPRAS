package com.pymes.commons.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pm_c_manufactura")
public class Manufactura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idManufactura;

    private Integer cantidad;

    @JsonIgnoreProperties(value = {"manufacturas","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduccion")
    private Produccion produccion;

    @JsonIgnoreProperties(value = {"manufacturas","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public Integer getIdManufactura() {
        return idManufactura;
    }

    public void setIdManufactura(Integer idManufactura) {
        this.idManufactura = idManufactura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Manufactura)) {
            return false;
        }
        Manufactura m = (Manufactura) obj;

        return this.idManufactura != null && this.idManufactura.equals(m.getIdManufactura());
    }

    
}
