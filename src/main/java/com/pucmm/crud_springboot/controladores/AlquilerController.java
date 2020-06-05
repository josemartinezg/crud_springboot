package com.pucmm.crud_springboot.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlquilerController {
    @GetMapping("/list-articulos")
    public String listArticulos(Model model){
        String mainHeader = "Alquileres";
        String pathHeader = "Realizar Alquileres";
        String plantilla = "realizarAlquiler.ftl";
        String copyRight = "Copyright &copy; Your Website 2019";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        model.addAttribute("plantilla", plantilla);
        return "/base";
    }
}
