package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
