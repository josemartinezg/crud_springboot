package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Estudiante;
import com.pucmm.crud_springboot.repositorios.EstudianteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class EstudiantesController {
    @GetMapping("/new-student")
    public String newStudent (Model model){
        String titulo = "Agregar Estudiante";
        model.addAttribute("titulo", titulo);
        return  "/agregarEstudiante";
    }
    @PostMapping("/add-student")
    public String addStudent(@RequestParam  int matricula, @RequestParam String nombre,
                                 @RequestParam String apellido, @RequestParam String telefono){
        Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
        System.out.println("Estudiante recibido" + estudiante.getMatricula());
        return "redirect:/new-student";
    }
}
