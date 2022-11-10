package com.pymes.compras.app.pedidos.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pymes.commons.pedidos.models.entity.Pedido;
import com.pymes.commons.services.CommonServiceImpl;
import com.pymes.compras.app.pedidos.models.repository.PedidoRepository;
@Service
public class PedidoServiceImpl extends  CommonServiceImpl<Pedido, PedidoRepository> implements PedidoService {
   // @Autowired
   // private PedidoRepository pedidoRepository;
    @Override

    @Transactional(readOnly = true)

    public List<Pedido> findByPassed(Integer estadoAprobado) {

        return repository.findByPassed(estadoAprobado);

    }
}
