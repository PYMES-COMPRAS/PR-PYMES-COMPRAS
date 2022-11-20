package com.prpymes.microservicios.app.ventas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.models.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {
	
	@Autowired
	private VentaRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Venta> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Venta save(Venta venta) {
		// TODO Auto-generated method stub
		return repository.save(venta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

}
