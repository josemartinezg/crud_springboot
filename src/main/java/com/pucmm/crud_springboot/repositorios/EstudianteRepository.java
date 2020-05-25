package com.pucmm.crud_springboot.repositorios;
import com.pucmm.crud_springboot.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
    Estudiante findByMatricula(int matricula);
}
