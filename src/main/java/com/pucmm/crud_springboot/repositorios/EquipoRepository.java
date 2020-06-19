package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EquipoRepository extends JpaRepository<Equipo,Long> {

}
