package com.prpymes.microservicios.app.compras.models.entity;

import javax.persistence.Column;
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
    @Column(name = "id")
    private Long idManufactura;

    private Short cantidad;

    @JsonIgnoreProperties(value = {"manufacturas","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduccion")
    private Produccion produccion;

    @Column(name = "id_producto")
    private Long producto;

    public Long getIdManufactura() {
        return idManufactura;
    }

    public void setIdManufactura(Long idManufactura) {
        this.idManufactura = idManufactura;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
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

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

}
