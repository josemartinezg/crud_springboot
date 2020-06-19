package com.pucmm.crud_springboot.repositorios;


import com.pucmm.crud_springboot.entidades.AlquilerEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AlquilerEquipoRepository extends JpaRepository<AlquilerEquipo, Long> {
}
