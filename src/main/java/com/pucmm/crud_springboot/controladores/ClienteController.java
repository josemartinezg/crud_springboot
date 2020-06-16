package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Cliente;
import com.pucmm.crud_springboot.repositorios.ClienteRepository;
import com.pucmm.crud_springboot.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository){
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    };

    @GetMapping("/clientes")
    public String clientes(Model model){
        String mainHeader = "Clientes";
        String pathHeader = "Gestión de Clientes";
        String copyRight = "Copyright &copy; Your Website 2019";
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        model.addAttribute("mainHeader", mainHeader);

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

        String mainHeader = "Clientes";
        String pathHeader = "Gestión de Clientes";
        String copyRight = "Copyright &copy; Your Website 2019";
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        model.addAttribute("mainHeader", mainHeader);

        List<Cliente> clientes = clienteService.getAllClients();
        model.addAttribute("clientes", clientes);

        String plantilla = "clientes.ftl";
        model.addAttribute("plantilla", plantilla);

        return "redirect:/clientes";
    }
}
