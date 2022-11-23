package com.prpymes.microservicios.commons.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonService<E> {
    
    public Iterable<E> findAll();

    public Optional<E> findById(Integer id);

    public E save(E entity);

    public void deleteById(Integer id);

    public Page<E> findAll(Pageable pageable);
}
