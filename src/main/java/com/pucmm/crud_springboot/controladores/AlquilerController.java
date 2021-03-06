package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.*;
import com.pucmm.crud_springboot.repositorios.*;
import com.pucmm.crud_springboot.services.AlquilerService;
import com.pucmm.crud_springboot.services.ClienteService;
import com.pucmm.crud_springboot.services.EquipoService;
import com.pucmm.crud_springboot.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import com.pucmm.crud_springboot.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Array;
import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class AlquilerController {
    private final SubFamiliaEquipoRepository sFEService;
    private final EquipoService equipoService;
    private final EstadoRepository estadoRepository;
    private final ClienteService clienteService;
    private final AlquilerService alquilerService;
    private final UsuarioService usuarioService;
    private final FacturaService facturaService;
    private final AlquilerEquipoRepository alquilerEquipoRepository;
    private final SFAverageRepository averageRepository;

    public AlquilerController(SubFamiliaEquipoRepository sFEService, EquipoService equipoService,
                              EstadoRepository estadoRepository, ClienteService clienteService,
                              AlquilerService alquilerService, UsuarioService usuarioService,
                              FacturaService facturaService, AlquilerEquipoRepository alquilerEquipoRepository,
                              SFAverageRepository averageRepository){
        this.sFEService = sFEService;
        this.equipoService = equipoService;
        this.estadoRepository = estadoRepository;
        this.clienteService = clienteService;
        this.alquilerService = alquilerService;
        this.alquilerEquipoRepository = alquilerEquipoRepository;
        this.facturaService = facturaService;
        this.usuarioService = usuarioService;
        this.averageRepository = averageRepository;
    }

    @RequestMapping("/")
    public ModelAndView getIndex(){
        return new ModelAndView("redirect:/realizar-alquiler");
    }

    @GetMapping("/realizar-alquiler")
    public String listArticulos(Principal principal, Model model, @RequestParam(required = false) Integer error){
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
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());

        setTemplateTitles(model, "Alquileres", "Realizar Alquiler", "", "realizarAlquiler.ftl", principal);
        /*Objetos de la plantilla*/
        List<Cliente> clientes = clienteService.getAllClients();
        List<Estado> listaDeEstados = estadoRepository.findAll();
        List<Equipo> listaEquipos = equipoService.findAllEquipos();
        String fechaDev = alquilerService.getStdFecha();
        model.addAttribute("clientes", clientes);
        model.addAttribute("estados", listaDeEstados);
        model.addAttribute("equipos", listaEquipos);
        model.addAttribute("fechaDevolucion", fechaDev);
        if (error != null){
            model.addAttribute("error", error);
        }
        model.addAttribute("nuevoAlquiler", 1);
        return "base";
    }

    /*Método para realizar la primera parte del alquiler.*/
    @PostMapping("/nuevo-alquiler")
    public String nuevoAlquiler(@RequestParam int cliente, Model model,
                                @RequestParam String fecha, @RequestParam int equipo,
                                @RequestParam int cantidad, Principal principal)
            throws IOException, ParseException {
         /*Creación de objetos en base a los parámetros-*/
        Equipo primerEquipo = equipoService.obtenerEquipo(equipo);
        Cliente clienteActual = clienteService.obtenerCliente(cliente);
        Date fechaDevolucion = Date.valueOf(fecha);
        /*Titulos de la plantilla*/
        String mainHeader = "Alquileres";
        String pathHeader = "Realizar Alquileres";
        String copyRight = "Copyright &copy; Your Website 2019";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);

        /*Elemntos de la plantilla*/
        String path = "../";
        model.addAttribute("path", path);
        String plantilla = "realizarAlquiler.ftl";
        model.addAttribute("plantilla", plantilla);
        setTemplateTitles(model, "Alquileres", "Realizar Alquiler", "../", "realizarAlquiler.ftl", principal);
        int cantidadExistencia = primerEquipo.getCantidadEnExistencia();

        if (cantidadExistencia >= cantidad){
            Alquiler alquiler = alquilerService.alquilerEnProceso(primerEquipo, clienteActual, fechaDevolucion, cantidad);
            long idAlq = alquiler.getId();
            return "redirect:/realizar-alquiler/" + idAlq;
        }else{
            return "redirect:/realizar-alquiler?error=1";
        }
    }
    @GetMapping("/realizar-alquiler/{id}" )
    public String agregarMasEquiposAlquiler(@PathVariable long id, Model model, @RequestParam(required = false) Integer error, Principal principal){
        /*TODO: Este método me presentará la plantilla "nuevoAlquiler", o una variante
        *  la cual tendra toda la información ya registrada del alquiler.
        * Luego debe de haber otro método que reciba unicamente un equipo nuevo que sea registrado, para agregarlo al
        * la lista de Equipos del Alquiler.*/
        /*Titulos y elementos de la plantilla*/
        setTemplateTitles(model, "Alquileres", "Realizar Alquiler", "../", "realizarAlquiler.ftl", principal);
        /*Objetos de la plantilla*/
        List<Cliente> clientes = clienteService.getAllClients();
        List<Estado> listaDeEstados = estadoRepository.findAll();
        List<Equipo> listaEquipos = equipoService.findAllEquipos();
        Alquiler alquilerActual = alquilerService.obtenerAlquiler(id);
        Set<AlquilerEquipo> equiposEnAlquiler =  alquilerActual.getEquipos();
        String fechaDev = alquilerService.getFechaDevString(id);
        if (error != null){
            model.addAttribute("error", error);
        }
        model.addAttribute("clientes", clientes);
        model.addAttribute("estados", listaDeEstados);
        model.addAttribute("equipos", listaEquipos);
        model.addAttribute("alquiler", alquilerActual);
        model.addAttribute("equiposEnAlquiler", equiposEnAlquiler);
        model.addAttribute("fechaDevolucion", fechaDev);
        model.addAttribute("nuevoAlquiler", 2);
        return "base";
    }
    @PostMapping("/agregar-equipo/{id}")
    public String agregarEquipo(Model model, @PathVariable long id, @RequestParam long equipo, @RequestParam int cantidad, Principal principal){
        /*Titulos de la plantilla*/
        setTemplateTitles(model, "Alquileres", "Realizar alquiler", "../", "realizarAlquiler.ftl", principal);
        /*Elemntos de la plantilla*/
        int cantidadExistencia = equipoService.obtenerEquipo(equipo).getCantidadEnExistencia();
        if(cantidadExistencia >= cantidad){
            alquilerService.agregarEquipo(id, equipo, cantidad);
            return "redirect:/realizar-alquiler/" + id;
        }else{
            return "redirect:/realizar-alquiler/" + id + "?error=1";
        }

    }

    @RequestMapping("/finalizar-alquiler/{id}")
    public String finalizarAlquiler(Model model, @PathVariable long id, Principal principal){
        /*Titulos de la plantilla*/
        setTemplateTitles(model, "Alquileres", "Nuevo Alquiler", "../", "realizarAlquiler.ftl", principal);
        alquilerService.finalizarAlquiler(id);
        return "redirect:/ver-alquileres";
    }

    @GetMapping("/ver-alquileres")
    public String verAlquileres(Model model, Principal principal){
        /*Titulos de la plantilla*/
        setTemplateTitles(model, "Alquileres", "Ver Alquileres", "", "verAlquileres.ftl", principal);
        /*Objetos de la plantilla*/
        List<Cliente> clientes = clienteService.getAllClients();
        List<Factura> facturas = facturaService.getAllFacturas();
        ArrayList<Float> chartData = getChartData();
        ArrayList<String> chartLabels = getChartLabels();
        model.addAttribute("id", 0);
        model.addAttribute("facturas", facturas);
        model.addAttribute("clientes", clientes);
        model.addAttribute("chartData", chartData);
        model.addAttribute("chartLabels", chartLabels);
        return "base";
    }
    @GetMapping("/ver-alquileres/{id}")
    public String verAlquileresPorCliente(Model model, @PathVariable long id, Principal principal){
        /*Titulos de la plantilla*/
        setTemplateTitles(model, "Alquileres", "Ver Alquileres Por Cliente", "", "verAlquileres.ftl", principal);
        long rentado = 1L;
        List<Cliente> clientes = clienteService.getAllClients();
        List<Factura> facturas = facturaService.getAlquilerByCliente(id);
        ArrayList<Float> chartData = getChartData();
        ArrayList<String> chartLabels = getChartLabels();
        model.addAttribute("id", id);
        model.addAttribute("facturas", facturas);
        model.addAttribute("clientes", clientes);
        model.addAttribute("chartData", chartData);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("chartLabels", chartLabels);
        return "base";
    }

    @GetMapping("/ver-alquileres-pendientes")
    public String verAlquileresPendientes(Model model, Principal principal){
        /*Titulos de la plantilla*/
        setTemplateTitles(model, "Alquileres", "Ver Alquileres Pendientes", "", "verAlquileres.ftl" , principal);
        long rentado = 1L;
        List<Factura> facturas = facturaService.getAlquilerByEstado(rentado);
        model.addAttribute("facturas", facturas);
        return "base";
    }



    public void setTemplateTitles(Model model, String mainHeader, String pathHeader, String path, String plantilla, Principal principal){
        String copyRight = "Copyright &copy; Your Website 2019";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        model.addAttribute("path", path);
        model.addAttribute("plantilla", plantilla);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());
    }

    public ArrayList<Float> getChartData(){
        ArrayList<Float> chartData = new ArrayList<>();
        List<SFAverage> list = this.averageRepository.findAll();
        for (SFAverage avg : list){
            chartData.add(avg.getPromedio());
        }
        return chartData;
    }

    public ArrayList<String> getChartLabels(){
        ArrayList<String> chartLabels = new ArrayList<>();
        List<SFAverage> list = this.averageRepository.findAll();
        for (SFAverage avg : list){
            chartLabels.add(avg.getCategoria());
        }
        return chartLabels;
    }


}
