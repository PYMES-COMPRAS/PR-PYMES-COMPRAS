package com.prpymes.microservicios.app.ventas.models.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.ventas.models.entity.Cliente;
import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.models.entity.VentaSelectTotal;

public interface VentaRepository extends CrudRepository<Venta, Long> {
	@Query(value ="SELECT SUM(total) AS total, fecha_creacion FROM ventas WHERE fecha_creacion BETWEEN ?1 and ?2 GROUP BY DATE_FORMAT(fecha_creacion,'%d/%m/%Y');", nativeQuery= true)
	public Iterable<String> findTotalSalesDate(@Param("term1") String term1, @Param("term2") String term2);
}
