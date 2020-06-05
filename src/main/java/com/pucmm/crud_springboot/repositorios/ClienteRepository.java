package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
