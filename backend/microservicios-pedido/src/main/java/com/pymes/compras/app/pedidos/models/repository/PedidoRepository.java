package com.pymes.compras.app.pedidos.models.repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.pymes.commons.pedidos.models.entity.Pedido;


import org.springframework.data.repository.CrudRepository;
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    @Query(value = "select * from PM_C_Pedido ", nativeQuery = true)

     public List<Pedido> findByPassed(Integer estadoAprobado);
}

