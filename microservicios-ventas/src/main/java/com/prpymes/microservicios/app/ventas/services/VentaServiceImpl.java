package com.prpymes.microservicios.app.ventas.services;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.ventas.models.entity.Cliente;
import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.models.entity.VentaSelectTotal;
import com.prpymes.microservicios.app.ventas.models.repository.VentaRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class VentaServiceImpl extends CommonServiceImpl<Venta, VentaRepository> implements VentaService {
	@Override
	@Transactional(readOnly = true)
	public Iterable<String> findTotalSalesDate(String term1, String term2) {
		return repository.findTotalSalesDate(term1, term2);
	}
	
}
