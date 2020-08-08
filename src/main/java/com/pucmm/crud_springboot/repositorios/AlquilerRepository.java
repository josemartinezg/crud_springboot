package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Alquiler;
import com.pucmm.crud_springboot.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
    List<Alquiler> findAllByEstado(Estado estado);
}
