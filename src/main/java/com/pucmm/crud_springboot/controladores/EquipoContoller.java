package com.pucmm.crud_springboot.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipoContoller {
    @GetMapping("/nuevo-equipo")
    public String listArticulos(Model model){
        String mainHeader = "Equipos";
        String pathHeader = "Nuevo Equipo";
        String plantilla = "nuevoEquipo.ftl";
        String copyRight = "Copyright &copy; Your Website 2020";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        model.addAttribute("plantilla", plantilla);
        return "/base";
    }
}
