package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
