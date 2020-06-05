package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.repositorios.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlquilerService {
    @Autowired
    private AlquilerRepository alquilerRepository;

}
