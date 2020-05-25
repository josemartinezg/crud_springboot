package com.pucmm.crud_springboot.repositorios;
import com.pucmm.crud_springboot.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
}
