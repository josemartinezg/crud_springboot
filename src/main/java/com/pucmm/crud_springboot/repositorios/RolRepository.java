package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, String> {

}
