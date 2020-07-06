package com.pucmm.crud_springboot;

import com.pucmm.crud_springboot.services.SeguridadServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CrudSpringbootApplication {

    public static void main(String[] args) {
        //Crear el template
        //SpringApplication.run(DemoSpringBootApplication.class, args);

        ApplicationContext applicationContext = SpringApplication.run(CrudSpringbootApplication.class, args);
        SeguridadServices seguridadServices = (SeguridadServices) applicationContext.getBean("seguridadServices");
        seguridadServices.crearUsuarioAdmin();
        seguridadServices.crearUsuarios();
    }

}
