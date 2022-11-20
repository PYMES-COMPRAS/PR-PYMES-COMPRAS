package com.prpymes.microservicios.app.ventas.services;

import java.util.Optional;

import com.prpymes.microservicios.app.ventas.models.entity.Venta;

public interface VentaService {
	public Iterable<Venta> findAll();
	public Optional<Venta> findById(Long id);
	public Venta save(Venta venta);
	public void deleteById(Long id);
}
