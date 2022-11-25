package com.prpymes.microservicios.app.compras.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prpymes.microservicios.app.compras.models.entity.Produccion;

public interface ProduccionRepository extends PagingAndSortingRepository<Produccion, Integer>{
    
    @Query(value="SELECT P.*, M.* FROM pm_c_produccion P INNER JOIN pm_c_manufactura M ON P.id = M.id_produccion", nativeQuery = true)
    public List<Object> innerJoinManufacturas();

}
