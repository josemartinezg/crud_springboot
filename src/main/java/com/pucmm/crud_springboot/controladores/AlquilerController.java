package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.SubFamiliaEquipo;
import com.pucmm.crud_springboot.repositorios.SubFamiliaEquipoRepository;
import com.pucmm.crud_springboot.services.SubFamiliaEquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class AlquilerController {
    private final SubFamiliaEquipoRepository sFEService;
    public AlquilerController(SubFamiliaEquipoRepository sFEService){
        this.sFEService = sFEService;
    }
    @GetMapping("/list-articulos")
    public String listArticulos(Model model){
        /*Titulos de la plantilla*/
        String mainHeader = "Alquileres";
        String pathHeader = "Realizar Alquileres";
        String copyRight = "Copyright &copy; Your Website 2019";
        model.addAttribute("mainHeader", mainHeader);
        model.addAttribute("pathHeader", pathHeader);
        model.addAttribute("copyRight", copyRight);
        /*Elemntos de la plantilla*/
        String plantilla = "realizarAlquiler.ftl";
        model.addAttribute("plantilla", plantilla);

        return "/base";
    }
}
