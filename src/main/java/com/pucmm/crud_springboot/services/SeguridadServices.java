package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.Rol;
import com.pucmm.crud_springboot.entidades.Usuario;
import com.pucmm.crud_springboot.repositorios.RolRepository;
import com.pucmm.crud_springboot.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeguridadServices implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    //Para encriptar la información del Usuario
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void crearUsuarioAdmin() {
        Rol rolAdmin = new Rol("ROLE_ADMIN");
        rolRepository.save(rolAdmin);

        Usuario admin = new Usuario();
        admin.setUsername("admin");
        admin.setEmail("admin@admin.com");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setNombre("Administrador");
        admin.setActivo(true);
        admin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));
        usuarioRepository.save(admin);
    }

    public void crearUsuarios(){
        Rol rolUser = new Rol("ROLE_USER");
        rolRepository.save(rolUser);
        Usuario usuario = new Usuario();
        usuario.setUsername("tomas");
        usuario.setEmail("tomas@gmail.com");
        usuario.setPassword("tomas");
        usuario.setNombre("Tomas");
        usuario.setActivo(true);
        usuario.setRoles(new HashSet<>(Arrays.asList(rolUser)));
        usuarioRepository.save(usuario);

        usuario.setUsername("josema");
        usuario.setEmail("josema@gmail.com");
        usuario.setPassword("josema");
        usuario.setNombre("Josema");
        usuario.setActivo(true);
        usuario.setRoles(new HashSet<>(Arrays.asList(rolUser)));
        usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActivo(), true, true, true, grantedAuthorities);
    }
}
