package com.pucmm.crud_springboot.controladores;

import com.pucmm.crud_springboot.services.SeguridadServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
public class LoginController {
    private final SeguridadServices seguridadServices;

    public LoginController(SeguridadServices seguridadServices){
        this.seguridadServices = seguridadServices;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

}
