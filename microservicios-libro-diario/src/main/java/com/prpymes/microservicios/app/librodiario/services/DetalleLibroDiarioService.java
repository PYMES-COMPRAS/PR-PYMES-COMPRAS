package com.prpymes.microservicios.app.librodiario.services;

import java.util.List;

import com.prpymes.microservicios.app.librodiario.models.entity.DetalleLibroDiario;


public interface DetalleLibroDiarioService {
	public Iterable<DetalleLibroDiario> saveAll(Iterable<DetalleLibroDiario> detalles);
}
