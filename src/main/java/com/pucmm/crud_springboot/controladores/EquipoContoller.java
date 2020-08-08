package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Equipo;
import com.pucmm.crud_springboot.entidades.SubFamiliaEquipo;
import com.pucmm.crud_springboot.entidades.Usuario;
import com.pucmm.crud_springboot.repositorios.EquipoRepository;
import com.pucmm.crud_springboot.repositorios.SubFamiliaEquipoRepository;
import com.pucmm.crud_springboot.services.EquipoService;
import com.pucmm.crud_springboot.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class EquipoContoller {
    private final SubFamiliaEquipoRepository sFEService;
    private final UsuarioService usuarioService;
    private final EquipoRepository equipoRepository;
    private final EquipoService equipoService;
    public EquipoContoller(SubFamiliaEquipoRepository sFEService, EquipoRepository equipoRepository,
                           EquipoService equipoService, UsuarioService usuarioService){
        this.sFEService = sFEService;
        this.equipoRepository = equipoRepository;
        this.equipoService = equipoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/equipos")
    public String listArticulos(Principal principal, Model model){
        /*Titulos de la plantilla*/
        String mainHeader = "Equipos";
        String pathHeader = "Nuevo Equipo";
        String copyRight = "Copyright &copy; Your Website 2020";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        Usuario usuario = usuarioService.getUsuarioLoggeado(principal);
        model.addAttribute("username", usuario.getUsername());
        model.addAttribute("isAdmin", usuario.isAdmin());

        /*Elementos de la plantilla*/
        String path = "";
        model.addAttribute("path", path);
        String plantilla = "nuevoEquipo.ftl";
        model.addAttribute("plantilla", plantilla);
        /*Objetos de la plantilla*/
        List<SubFamiliaEquipo> sFEList = sFEService.findAll();
        model.addAttribute("familias", sFEList);
        List<Equipo> equipoList = equipoRepository.findAll();
        model.addAttribute("equipos", equipoList);
        return "/base";
    }

    @PostMapping("/crear-equipo/")
    public String crearEquipo(@RequestParam String marca, @RequestParam String modelo,
                              @RequestParam String descripcion, @RequestParam float costo,
                              @RequestParam MultipartFile imagen, @RequestParam int existencia,
                              @RequestParam long familia, Model model) throws IOException {
        SubFamiliaEquipo subFamilia = sFEService.getOne(familia);
        //Se convierte el MiltipartFile de Spring a ByteArrey y luego a Base64 con estos métodos.
        String encodedImage = Base64.getEncoder().encodeToString(imagen.getBytes());
        /*Creacion equipo*/
        if (imagen != null && descripcion != null){
            Equipo nuevoEquipo = new Equipo(marca, modelo, descripcion, costo, encodedImage, existencia, subFamilia);
            equipoRepository.save(nuevoEquipo);
        }else if(imagen == null){
            Equipo nuevoEquipo = new Equipo(marca, modelo, descripcion, costo, existencia, subFamilia);
            equipoRepository.save(nuevoEquipo);
        }
        /*Titulos de la plantilla*/
        String mainHeader = "Equipos";
        String pathHeader = "Nuevo Equipo";
        String copyRight = "Copyright &copy; Your Website 2020";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        /*Elementos de la plantilla*/
        String path = "";
        model.addAttribute("path", path);
        String plantilla = "nuevoEquipo.ftl";
        model.addAttribute("plantilla", plantilla);
        /*Objetos de la plantilla*/
        return "redirect:/equipos";
    }
    @GetMapping("ver-equipo/{id}")
    public String verEquipo (Model model, @PathVariable long id){
        /*Titulos de la plantilla*/
        String mainHeader = "Equipos";
        String pathHeader = "Ver Equipo";
        String copyRight = "Copyright &copy; Your Website 2020";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        /*Objetos en la plantilla*/
        Equipo equipoActual = equipoRepository.getOne(id);
        model.addAttribute("equipo", equipoActual);
        /*Elementos de la plantilla*/
        String path = "../";
        model.addAttribute("path", path);
        String plantilla = "verEquipo.ftl";
        model.addAttribute("plantilla", plantilla);
        return "/base";
    }
    @GetMapping("/editar-equipo")
    public String plantillaEditarEquipo(Model model, @RequestParam long id){
        /*Titulos de la plantilla*/
        String mainHeader = "Equipos";
        String pathHeader = "Editar Equipo";
        String copyRight = "Copyright &copy; Your Website 2020";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        /*Objetos en la plantilla*/
        Equipo equipoActual = equipoRepository.getOne(id);
        model.addAttribute("equipo", equipoActual);
        List<SubFamiliaEquipo> sFEList = sFEService.findAll();
        model.addAttribute("familias", sFEList);
        List<Equipo> equipoList = equipoRepository.findAll();
        model.addAttribute("equipos", equipoList);
        /*Elementos de la plantilla*/
        String path = "../";
        model.addAttribute("edit", 1);
        model.addAttribute("path", path);
        String plantilla = "editarEquipo.ftl";
        model.addAttribute("plantilla", plantilla);

        return "/base";
    }
    @PostMapping("/editar-equipo/{id}")
    public String editarEquipo(@RequestParam String marca, @RequestParam String modelo,
                               @RequestParam String descripcion, @RequestParam float costo,
                               @RequestParam MultipartFile imagen, @RequestParam int existencia,
                               @RequestParam long familia, @PathVariable long id,Model model) throws IOException {
        SubFamiliaEquipo subFamilia = sFEService.getOne(familia);
        String encodedImage = Base64.getEncoder().encodeToString(imagen.getBytes());
        /*Creacion equipo*/
        if (imagen != null && descripcion != null){
            Equipo equipoModificado = new Equipo(marca, modelo, descripcion, costo, encodedImage, existencia, subFamilia);
            equipoService.actualizaEquipo(id, equipoModificado);
        }else if(imagen == null){
            Equipo equipoModificado = new Equipo(marca, modelo, descripcion, costo, existencia, subFamilia);
            equipoService.actualizaEquipo(id, equipoModificado);
        }
        /*Titulos de la plantilla*/
        String mainHeader = "Equipos";
        String pathHeader = "Nuevo Equipo";
        String copyRight = "Copyright &copy; Your Website 2020";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        /*Elementos de la plantilla*/
        String path = "";
        model.addAttribute("edit", 0);
        model.addAttribute("path", path);
        String plantilla = "nuevoEquipo.ftl";
        model.addAttribute("plantilla", plantilla);
        return "redirect:/equipos";
    }

    @RequestMapping("/eliminar-equipo/{id}")
    public String eliminarEquipo(Model model, @PathVariable long id){
        /*Titulos de la plantilla*/
        String mainHeader = "Equipos";
        String pathHeader = "Ver Equipo";
        String copyRight = "Copyright &copy; Your Website 2020";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        /*Objetos en la plantilla*/
        equipoService.eliminarEquipo(id);
        List<SubFamiliaEquipo> sFEList = sFEService.findAll();
        model.addAttribute("familias", sFEList);
        List<Equipo> equipoList = equipoRepository.findAll();
        model.addAttribute("equipos", equipoList);
        String path = "../";
        model.addAttribute("edit", 0);
        model.addAttribute("path", path);
        String plantilla = "nuevoEquipo.ftl";
        model.addAttribute("plantilla", plantilla);
        return "base";
    }


}
