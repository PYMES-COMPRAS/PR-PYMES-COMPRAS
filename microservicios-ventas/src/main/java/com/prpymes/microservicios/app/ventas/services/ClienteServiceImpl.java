package com.prpymes.microservicios.app.ventas.services;

import org.springframework.stereotype.Service;

import com.prpymes.microservicios.app.ventas.models.entity.Cliente;
import com.prpymes.microservicios.app.ventas.models.entity.Venta;
import com.prpymes.microservicios.app.ventas.models.repository.ClienteRepository;
import com.prpymes.microservicios.app.ventas.models.repository.VentaRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;
@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService {

}
