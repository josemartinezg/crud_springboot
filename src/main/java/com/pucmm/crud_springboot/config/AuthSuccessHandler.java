package com.pucmm.crud_springboot.config;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pucmm.crud_springboot.entidades.Usuario;
import com.pucmm.crud_springboot.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        Usuario usuario;
        if(authentication.getPrincipal() instanceof Principal) {
             String username = ((Principal) authentication.getPrincipal()).getName();
             usuario = usuarioRepository.findByUsername(username);

        }else {
            String username = ((UserDetails)authentication.getPrincipal()).getUsername();
            usuario = usuarioRepository.findByUsername(username);
        }
        session.setAttribute("usuario", usuario);
        response.sendRedirect("/");
    }
}