package com.prpymes.microservicios.app.librodiario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.librodiario.models.entity.DetalleLibroDiario;
import com.prpymes.microservicios.app.librodiario.models.repository.DetalleLibroDiarioRepository;

@Service
public class DetalleLibroDiarioServiceImpl implements DetalleLibroDiarioService {
	
	@Autowired
	private DetalleLibroDiarioRepository repository;
	
	@Override
	@Transactional
	public Iterable<DetalleLibroDiario> saveAll(Iterable<DetalleLibroDiario> detalles) {
		return  repository.saveAll(detalles);
	}
}
