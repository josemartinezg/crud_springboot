package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Cliente;
import com.pucmm.crud_springboot.entidades.Usuario;
import com.pucmm.crud_springboot.repositorios.ClienteRepository;
import com.pucmm.crud_springboot.services.ClienteService;
import com.pucmm.crud_springboot.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@Controller
public class ClienteController {
    private final ClienteService clienteService;
    private final UsuarioService usuarioService;
    private final ClienteRepository clienteRepository;
    private final String mainHeader = "Clientes";
    private final String pathHeader = "Gestión de Clientes";
    private final String copyRight = "Copyright &copy; Your Website 2019";

    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository, UsuarioService usuarioService){
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
        this.usuarioService = usuarioService;
    };

    @GetMapping("/clientes")
    public String clientes(Principal principal, Model model){
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        //Variable que indica no es editando
        model.addAttribute("edicion", 0);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);
        return "/base";
    };

    @PostMapping("/crearCliente")
    public String crearCliente(@RequestParam String nombre, @RequestParam String cedula,
                               @RequestParam String apellido, @RequestParam MultipartFile imagen,
                               @RequestParam String id, Model model) throws IOException {
        String encodedImage = Base64.getEncoder().encodeToString(imagen.getBytes());
        if(!id.equals("")){
            System.out.println(" ------- Entre con el id: " + id);
            Cliente nuevoCliente = new Cliente(Long.parseLong(id), nombre, apellido, cedula, encodedImage);
            System.out.println(nuevoCliente.toString());
            clienteRepository.save(nuevoCliente);
        }else{
            Cliente nuevoCliente = new Cliente(nombre, apellido, cedula, encodedImage);
            clienteRepository.save(nuevoCliente);
        }


        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);

        //Variable que indica no es editando
        model.addAttribute("edicion", 0);

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);

        return "redirect:/clientes";
    }

    @GetMapping("/editar-cliente")
    public String editarCliente(Principal principal, Model model, @RequestParam long id){
        Cliente clienteEditado = clienteRepository.getOne(id);
        model.addAttribute("clienteEditado", clienteEditado);
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());

        //Variable que indica es editando
        model.addAttribute("edicion", 1);

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);

        return "/base";
    }

    @RequestMapping("/eliminar-cliente")
    public String eliminarCliente(Principal principal, Model model, @RequestParam long id){
        if(id >= 0){
            clienteRepository.deleteById(id);
        }else{
            return "/base";
        }
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        //Variable que indica no es editando
        model.addAttribute("edicion", 0);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);

        return "/base";
    }
}
