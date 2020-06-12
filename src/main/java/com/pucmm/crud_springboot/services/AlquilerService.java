package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.Alquiler;
import com.pucmm.crud_springboot.entidades.Cliente;
import com.pucmm.crud_springboot.entidades.Equipo;
import com.pucmm.crud_springboot.entidades.Estado;
import com.pucmm.crud_springboot.repositorios.AlquilerRepository;
import com.pucmm.crud_springboot.repositorios.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class AlquilerService {
    @Autowired
    private AlquilerRepository alquilerRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public Alquiler nuevoAlquiler(Equipo primerEquipoAlquiler, Cliente clienteActual, Estado estado, Date fechaEsperada) {
        Alquiler nuevoAlquiler = new Alquiler(clienteActual, estado, new Date(System.currentTimeMillis()), fechaEsperada);
        Set<Equipo> misEquipos = null;
        misEquipos.add(primerEquipoAlquiler);
        nuevoAlquiler.setListaDeEquiposRentados(misEquipos);
        alquilerRepository.save(nuevoAlquiler);
        return nuevoAlquiler;
    }
    /*Método escrito para realizar la primera parte del alquiler*/
    public Alquiler alquilerEnProceso (Equipo primerEquipoAlquiler, Cliente clienteActual,Date fechaEsperada){
        Estado enProceso = new Estado((long)5, "En proceso");
        Alquiler alquilerParcial = new Alquiler(clienteActual, enProceso, fechaEsperada);
        Set<Equipo> misEquipos = new HashSet<>();
        misEquipos.add(primerEquipoAlquiler);
        alquilerParcial.setListaDeEquiposRentados(misEquipos);
        alquilerRepository.save(alquilerParcial);
        return alquilerParcial;
    }

}
