package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
