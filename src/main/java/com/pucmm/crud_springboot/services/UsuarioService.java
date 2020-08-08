package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.Usuario;
import com.pucmm.crud_springboot.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioLoggeado(Principal principal){
        String username = principal.getName();
        return usuarioRepository.findByUsername(username);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getOne(String id){
        return usuarioRepository.getOne(id);
    }
}
