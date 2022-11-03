package com.prpymes.microservicios.app.ventas.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.prpymes.microservicios.app.ventas.models.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
