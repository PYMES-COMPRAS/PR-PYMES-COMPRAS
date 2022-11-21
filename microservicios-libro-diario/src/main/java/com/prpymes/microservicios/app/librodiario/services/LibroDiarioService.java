package com.prpymes.microservicios.app.librodiario.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.prpymes.microservicios.app.librodiario.models.entity.LibroDiario;

public interface LibroDiarioService {
	public LibroDiario save(LibroDiario librodiario);
	
	public List<LibroDiario> findByDatesAndBookType(Date fecha_inicio, Date fecha_fin, String tipo_libro);

}
