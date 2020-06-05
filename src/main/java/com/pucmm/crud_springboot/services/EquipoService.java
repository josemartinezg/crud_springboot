package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.repositorios.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
    //Inyeccion del repositorio
    @Autowired
    private EquipoRepository equipoRepository;
}
