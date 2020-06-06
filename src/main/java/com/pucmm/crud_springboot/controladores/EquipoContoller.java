package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Equipo;
import com.pucmm.crud_springboot.entidades.SubFamiliaEquipo;
import com.pucmm.crud_springboot.repositorios.EquipoRepository;
import com.pucmm.crud_springboot.repositorios.SubFamiliaEquipoRepository;
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
public class EquipoContoller {
    private final SubFamiliaEquipoRepository sFEService;
    private final EquipoRepository equipoRepository;
    public EquipoContoller(SubFamiliaEquipoRepository sFEService, EquipoRepository equipoRepository){
        this.sFEService = sFEService;
        this.equipoRepository = equipoRepository;
    }
    @GetMapping("/nuevo-equipo")
    public String listArticulos(Model model){
        /*Titulos de la plantilla*/
        String mainHeader = "Equipos";
        String pathHeader = "Nuevo Equipo";
        String copyRight = "Copyright &copy; Your Website 2020";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        /*Elementos de la plantilla*/
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
        String plantilla = "nuevoEquipo.ftl";
        model.addAttribute("plantilla", plantilla);
        /*Objetos de la plantilla*/
        return "redirect:/nuevo-equipo/";
    }
}
