package com.pucmm.crud_springboot.repositorios;
import com.pucmm.crud_springboot.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
    Estudiante findByMatricula(int matricula);
    int deleteByMatricula(int matricula);
}
