package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo,Long> {
}
