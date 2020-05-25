package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.entidades.Estudiante;
import com.pucmm.crud_springboot.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller()
public class EstudiantesController {

    private ArrayList<Estudiante> misEstudiantes = new ArrayList<Estudiante>();

    private final EstudianteRepository estudianteRepository;

    public EstudiantesController(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;
    }
    public void createStudentList(){
        if (misEstudiantes.size() == 0){
            estudianteRepository.save(new Estudiante(250, "Jose", "Martinez", "809-912-6000"));
            misEstudiantes.add(new Estudiante(250, "Jose", "Martinez", "809-912-6000"));
            misEstudiantes.add(new Estudiante(550, "Saul", "Feliciano", "849-999-5557"));
            misEstudiantes.add(new Estudiante(550, "Miguel", "Moronta", "829-999-5557"));
        }
    }
    @GetMapping("/list-students")
    public String listStudent(Model model){
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        String titulo = "Lista de Estudiantes";
        model.addAttribute("titulo", titulo);
        model.addAttribute("misEstudiantes", estudiantes);
        return "/tablaEstudiantes";
    }
    @GetMapping("/new-student")
    public String newStudent (Model model){
        String titulo = "Agregar Estudiante";
        model.addAttribute("titulo", titulo);
        return "/agregarEstudiante";
    }
    @PostMapping("/add-student")
    public String addStudent(@RequestParam int matricula, @RequestParam String nombre,
                                 @RequestParam String apellido, @RequestParam String telefono){
        Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
        System.out.println("Estudiante recibido" + estudiante.getMatricula());
        estudianteRepository.save(estudiante);
        return "redirect:/list-students";
    }
    @GetMapping("edit-student")
    public String editStudent(Model model, @RequestParam int matricula){
        String titulo = "Editar Estudiante";
        Estudiante datosEstudiante = new Estudiante(0, "", "", "");
        Estudiante estudiante = estudianteRepository.findByMatricula(matricula);
        if(estudiante != null){
            datosEstudiante = estudiante;
        }
        model.addAttribute("titulo", titulo);
        model.addAttribute("estudiante", datosEstudiante);
        return "/editarEstudiante";
    }
    @PostMapping("edit-student/{matricula}")
    public String makeEditStudent(Model model, @RequestParam int matricula, @RequestParam String nombre,
                                  @RequestParam String apellido, @RequestParam String telefono){
        String titulo = "Editar Estudiante";
        Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);
        estudianteRepository.save(estudiante);
        model.addAttribute("titulo", titulo);
        model.addAttribute("estudiantes", misEstudiantes);
        return "redirect:/list-students";
    }
    @GetMapping("delete/{matricula}")
    public String deleteStudent(Model model, @PathVariable int matricula){
        estudianteRepository.deleteByMatricula(matricula);
        model.addAttribute("estudiantes", misEstudiantes);
        return "redirect:/list-students";
    }

}
