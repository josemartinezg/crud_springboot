package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.*;
import com.pucmm.crud_springboot.repositorios.EstadoRepository;
import com.pucmm.crud_springboot.repositorios.SubFamiliaEquipoRepository;
import com.pucmm.crud_springboot.services.AlquilerService;
import com.pucmm.crud_springboot.services.ClienteService;
import com.pucmm.crud_springboot.services.EquipoService;
import com.pucmm.crud_springboot.services.SubFamiliaEquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class AlquilerController {
    private final SubFamiliaEquipoRepository sFEService;
    private final EquipoService equipoService;
    private final EstadoRepository estadoRepository;
    private final ClienteService clienteService;
    private final AlquilerService alquilerService;
    public AlquilerController(SubFamiliaEquipoRepository sFEService, EquipoService equipoService,
                              EstadoRepository estadoRepository, ClienteService clienteService,
                              AlquilerService alquilerService){
        this.sFEService = sFEService;
        this.equipoService = equipoService;
        this.estadoRepository = estadoRepository;
        this.clienteService = clienteService;
        this.alquilerService = alquilerService;
    }
    @GetMapping("/realizar-alquiler")
    public String listArticulos(Model model){
        /*Titulos de la plantilla*/
        String mainHeader = "Alquileres";
        String pathHeader = "Realizar Alquileres";
        String copyRight = "Copyright &copy; Your Website 2019";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        /*Elemntos de la plantilla*/
        String path = "";
        model.addAttribute("path", path);
        String plantilla = "realizarAlquiler.ftl";
        model.addAttribute("plantilla", plantilla);
        /*Objetos de la plantilla*/
        List<Cliente> clientes = clienteService.getAllClients();
        List<Estado> listaDeEstados = estadoRepository.findAll();
        List<Equipo> listaEquipos = equipoService.findAllEquipos();
        model.addAttribute("clientes", clientes);
        model.addAttribute("estados", listaDeEstados);
        model.addAttribute("equipos", listaEquipos);
        model.addAttribute("nuevoAlquiler", 1);
        return "/base";
    }
    @PostMapping("/alquilar/{id}")
    public String realizarAlquiler(@PathVariable long id, Model model){
        Equipo equipoActual = equipoService.obtenerEquipo(id);
        return "/base";
    }

    @PostMapping("/agregar-equipo")
    public String agregarEquipoAlquiler(@RequestParam int cliente, @RequestParam int estado,
                                        @RequestParam String date, @RequestParam int equipo,
                                        Model model) throws IOException, ParseException {
        System.out.println("Cliente " + cliente + " estado " + estado
        + " fecha: " + date +" equipo: " + equipo);

        Equipo primerEquipo = equipoService.obtenerEquipo(equipo);
        Cliente clienteActual = clienteService.obtenerCliente(cliente);
        Estado estadoActual = estadoRepository.findById(estado).get();
        SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
        Date parsedDate = format.parse(date);
        java.sql.Date fechaDevolucion = (java.sql.Date) parsedDate;
        Equipo equipoActual = equipoService.obtenerEquipo(equipo);

//        Alquiler alquiler = new Alquiler(clienteActual, estadoActual, fechaAlquiler, fechaDevolucion);
        Alquiler alquiler = alquilerService.nuevoAlquiler(primerEquipo, clienteActual, estadoActual, fechaDevolucion);
        long idAlq = alquiler.getId();
        return "redirect:/realizar-alquiler/{" + idAlq + '}';

    }
    @GetMapping("/realizar-alquiler/{id}")
    public String agregarMasEquiposAlquiler(@PathVariable String id){
        /*TODO: Este método me presentará la plantilla "nuevoAlquiler", o una variante
        *  la cual tendra toda la información ya registrada del alquiler.
        * Luego debe de haber otro método que reciba unicamente un equipo nuevo que sea registrado, para agregarlo al
        * la lista de Equipos del Alquiler.*/
        return "/base";
    }
}
