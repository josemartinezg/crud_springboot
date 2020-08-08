package com.pucmm.crud_springboot.repositorios;

import com.pucmm.crud_springboot.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByUsername(String username);
}
