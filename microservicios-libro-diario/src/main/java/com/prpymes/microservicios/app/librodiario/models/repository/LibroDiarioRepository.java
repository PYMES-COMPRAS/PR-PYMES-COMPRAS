package com.prpymes.microservicios.app.librodiario.models.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.librodiario.models.entity.LibroDiario;

public interface LibroDiarioRepository extends CrudRepository<LibroDiario , Long> {
	@Query("select distinct l from LibroDiario l join fetch l.detalles d where d.libroDiario = l.id and l.fecha >= :fecha_inicio and l.fecha <= :fecha_fin and l.tipo_libro = :tipo_libro")
	public List<LibroDiario> findByDatesAndBookType(@Param("fecha_inicio") Date fecha_inicio, @Param("fecha_fin") Date fecha_fin, @Param("tipo_libro") String tipo_libro);
}
