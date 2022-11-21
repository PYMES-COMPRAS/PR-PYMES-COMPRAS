package com.prpymes.microservicios.app.ventas.services;



import java.util.Date;

import com.prpymes.microservicios.app.ventas.models.entity.Cliente;
import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.models.entity.VentaSelectTotal;
import com.prpymes.microservicios.commons.services.CommonService;

public interface VentaService extends CommonService<Venta> {
	public Iterable<String> findTotalSalesDate(String term1, String term2);
}
