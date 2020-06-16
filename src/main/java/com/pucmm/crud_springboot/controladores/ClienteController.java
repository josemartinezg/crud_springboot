package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Cliente;
import com.pucmm.crud_springboot.repositorios.ClienteRepository;
import com.pucmm.crud_springboot.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;
    private final String mainHeader = "Clientes";
    private final String pathHeader = "Gestión de Clientes";
    private final String copyRight = "Copyright &copy; Your Website 2019";

    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository){
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    };

    @GetMapping("/clientes")
    public String clientes(Model model){
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);
        return "/base";
    };

    @PostMapping("/crearCliente")
    public String crearCliente(@RequestParam String nombre, @RequestParam String cedula,
                               @RequestParam String apellido, @RequestParam MultipartFile imagen,
                               Model model) throws IOException {
        String encodedImage = Base64.getEncoder().encodeToString(imagen.getBytes());
        Cliente nuevoCliente = new Cliente(nombre, apellido, cedula, encodedImage);
        clienteRepository.save(nuevoCliente);

        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);

        return "redirect:/clientes";
    }

    @GetMapping("/editar-cliente")
    public String editarCliente(Model model, @RequestParam long id){
        Cliente clienteEditado = clienteRepository.getOne(id);
        model.addAttribute("clienteEditado", clienteEditado);
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);

        return "/base";
    }

    @RequestMapping("/eliminar-cliente")
    public String eliminarCliente(Model model, @RequestParam long id){
        clienteRepository.deleteById(id);
        model.addAttribute("pathHeader", this.pathHeader);
        model.addAttribute("copyRight", this.copyRight);
        model.addAttribute("mainHeader", this.mainHeader);

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);

        return "/base";
    }
}
