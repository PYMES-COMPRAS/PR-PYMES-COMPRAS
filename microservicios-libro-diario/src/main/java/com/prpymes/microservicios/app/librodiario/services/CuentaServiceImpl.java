package com.prpymes.microservicios.app.librodiario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.librodiario.models.entity.Cuentas;
import com.prpymes.microservicios.app.librodiario.models.repository.CuentaRepository;



@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Cuentas> findByIdEmpresa(Long id_empresa) {
		// TODO Auto-generated method stub
		return repository.findByIdEmpresa(id_empresa);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cuentas> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Cuentas save(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return repository.save(cuenta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}
}
