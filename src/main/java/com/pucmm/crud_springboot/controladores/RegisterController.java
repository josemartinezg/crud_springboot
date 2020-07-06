package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Rol;
import com.pucmm.crud_springboot.entidades.Usuario;
import com.pucmm.crud_springboot.services.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
public class RegisterController {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private final UsuarioService usuarioService;
    private final String mainHeader = "Clientes";
    private final String pathHeader = "Gestión de Clientes";
    private final String copyRight = "Copyright &copy; Your Website 2019";

    public RegisterController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterPage(@RequestParam Optional<String> error){
        return new ModelAndView("register", "error", error);
    }

    @PostMapping("/register/registrarUsuario")
    private String registrarUsuario(Model model, @RequestParam String username, @RequestParam String email,
                                    @RequestParam String password, @RequestParam String nombre){
        Rol rolUser = new Rol("ROLE_USER");
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setActivo(true);
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(bCryptPasswordEncoder.encode(password));
        usuario.setRoles(new HashSet<>(Arrays.asList(rolUser)));
        usuarioService.save(usuario);
        return "redirect:/login";
    }
}
