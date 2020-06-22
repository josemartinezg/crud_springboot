package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findAllByAlquiler_Estado_IdOrderByFechaFacturacion(long id);
    List <Factura> findAllByAlquiler_ClienteId(long id);
}
