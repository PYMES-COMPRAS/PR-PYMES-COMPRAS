package com.prpymes.microservicios.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



public class CommonServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonService<E> {

	@Autowired
	protected R repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public E save(E venta) {
		return repository.save(venta);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
