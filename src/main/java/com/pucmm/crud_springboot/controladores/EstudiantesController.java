package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Estudiante;
import com.pucmm.crud_springboot.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller()
public class EstudiantesController {
    private ArrayList<Estudiante> misEstudiantes = new ArrayList<Estudiante>();
    public void createStudentList(){
        if (misEstudiantes.size() == 0){
            misEstudiantes.add(new Estudiante(250, "Jose", "Martinez", "809-912-6000"));
            misEstudiantes.add(new Estudiante(550, "Saul", "Feliciano", "849-999-5557"));
            misEstudiantes.add(new Estudiante(550, "Miguel", "Moronta", "829-999-5557"));
        }
    }
    @GetMapping("/list-students")
    public String listStudent(Model model){
        createStudentList();
        String titulo = "Lista de Estudiantes";
        model.addAttribute("titulo", titulo);
        model.addAttribute("misEstudiantes", misEstudiantes);
        return "/tablaEstudiantes";
    }
    @GetMapping("/new-student")
    public String newStudent (Model model){
        String titulo = "Agregar Estudiante";
        model.addAttribute("titulo", titulo);
        createStudentList();
        return "/agregarEstudiante";
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestParam int matricula, @RequestParam String nombre,
                                 @RequestParam String apellido, @RequestParam String telefono){
        Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
        System.out.println("Estudiante recibido" + estudiante.getMatricula());
        return "redirect:/new-student";
    }
    @GetMapping("edit-student")
    public String editStudent(Model model, @RequestParam int matricula){
        String titulo = "Editar Estudiante";
        Estudiante datosEstudiante = new Estudiante(0, "", "", "");
        for (Estudiante estud: misEstudiantes){
            if (estud.getMatricula() == matricula){
                datosEstudiante = estud;
            }
        }
        model.addAttribute("titulo", titulo);
        model.addAttribute("estudiante", datosEstudiante);
        return "/editarEstudiante";
    }
    @PostMapping("edit-student/{matricula}")
    public String makeEditStudent(Model model, @RequestParam int matricula, @RequestParam String nombre,
                                  @RequestParam String apellido, @RequestParam String telefono){

        Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
        int idx = 0;
        for (Estudiante estud: misEstudiantes) {
            if(estud.getMatricula() == matricula) {
                misEstudiantes.set(idx, estudiante);
                break;
            }
            idx++;
        }
        model.addAttribute("estudiantes", misEstudiantes);
        return "redirect:/list-student";
    }
    @PostMapping("delete/{matricula}")
    public String deleteStudent(Model model, @RequestParam int matricula){
        for (Estudiante estud: misEstudiantes){
            if (estud.getMatricula() == matricula){
                misEstudiantes.remove(estud);
                break;
            }
        }
        model.addAttribute("estudiantes", misEstudiantes);
        return "redirect:/list-students";
    }

}
