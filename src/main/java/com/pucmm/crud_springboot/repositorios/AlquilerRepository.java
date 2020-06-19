package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

}
