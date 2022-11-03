package com.prpymes.microservicios.app.ventas.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.prpymes.microservicios.app.ventas.models.entity.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long> {

}
