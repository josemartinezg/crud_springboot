package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.Alquiler;
import com.pucmm.crud_springboot.entidades.Cliente;
import com.pucmm.crud_springboot.entidades.Equipo;
import com.pucmm.crud_springboot.entidades.Estado;
import com.pucmm.crud_springboot.repositorios.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Set;

@Service
public class AlquilerService {
    @Autowired
    private AlquilerRepository alquilerRepository;

    public Alquiler nuevoAlquiler(Equipo primerEquipoAlquiler, Cliente clienteActual, Estado estado, Date fechaEsperada) {
        Alquiler nuevoAlquiler = new Alquiler(clienteActual, estado, new Date(System.currentTimeMillis()), fechaEsperada);
        Set<Equipo> misEquipos = null;
        misEquipos.add(primerEquipoAlquiler);
        nuevoAlquiler.setListaDeEquiposRentados(misEquipos);
        alquilerRepository.save(nuevoAlquiler);
        return nuevoAlquiler;
    }

}
