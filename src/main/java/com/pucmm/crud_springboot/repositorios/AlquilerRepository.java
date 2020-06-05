package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

}
