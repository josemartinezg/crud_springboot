package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.Equipo;
import com.pucmm.crud_springboot.repositorios.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EquipoService {
    //Inyeccion del repositorio
    @Autowired
    private EquipoRepository equipoRepository;

    @Transactional
    public void eliminarEquipo(long id){
        Equipo equipoActual = equipoRepository.getOne(id);
        equipoRepository.delete(equipoActual);
    }

}
