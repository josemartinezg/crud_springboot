package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Rol;
import com.pucmm.crud_springboot.entidades.Usuario;
import com.pucmm.crud_springboot.repositorios.RolRepository;
import com.pucmm.crud_springboot.services.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
public class UsuariosController {
    private final String mainHeader = "Clientes";
    private final String pathHeader = "Gestión de Clientes";
    private final String copyRight = "Copyright &copy; Your Website 2019";
    private final UsuarioService usuarioService;
    private final RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UsuariosController(UsuarioService usuarioService, RolRepository rolRepository){
        this.usuarioService = usuarioService;
        this.rolRepository = rolRepository;
    }

    @GetMapping("/usuarios")
    public String usuarios(Principal principal, Model model){
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());

        List<Rol> roles = rolRepository.findAll();
        model.addAttribute("roles", roles);

        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);

        //Variable que indica no es editando
        model.addAttribute("edicion", 0);

        String plantilla = "usuarios.ftl";
        model.addAttribute("plantilla", plantilla);
        return "/base";
    }

    @PostMapping("/usuarios/registrarUsuario")
    private String registrarUsuario(Principal principal, Model model, @RequestParam String username,
                                    @RequestParam String email, @RequestParam String password,
                                    @RequestParam String nombre, @RequestParam String rol){
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());

        Rol rolUser = rolRepository.getOne(rol);
        usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setActivo(true);
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(bCryptPasswordEncoder.encode(password));
        usuario.setRoles(new HashSet<>(Arrays.asList(rolUser)));
        usuarioService.save(usuario);

        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);

        //Variable que indica no es editando
        model.addAttribute("edicion", 0);

        String plantilla = "usuarios.ftl";
        model.addAttribute("plantilla", plantilla);

        return "/base";
    }

    @GetMapping("/usuarios/editarUsuario")
    public String editarUsuario(Principal principal, Model model, @RequestParam String id){
        Usuario usuarioEditado = usuarioService.getOne(id);
        model.addAttribute("usuarioEditado", usuarioEditado);
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());

        model.addAttribute("edicion", 1);

        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);



        return "/base";
    }
}
