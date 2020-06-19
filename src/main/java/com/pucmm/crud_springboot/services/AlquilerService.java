package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.*;
import com.pucmm.crud_springboot.repositorios.AlquilerEquipoRepository;
import com.pucmm.crud_springboot.repositorios.AlquilerRepository;
import com.pucmm.crud_springboot.repositorios.EquipoRepository;
import com.pucmm.crud_springboot.repositorios.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AlquilerService {
    @Autowired
    private AlquilerRepository alquilerRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private AlquilerEquipoRepository alquilerEquipoRepository;
    @Autowired
    private EquipoRepository equipoRepository;
    public Alquiler nuevoAlquiler(Equipo primerEquipoAlquiler, Cliente clienteActual, Estado estado, Date fechaEsperada) {
        Alquiler nuevoAlquiler = new Alquiler(clienteActual, estado, new Date(System.currentTimeMillis()), fechaEsperada);
        Set<Equipo> misEquipos = null;
        misEquipos.add(primerEquipoAlquiler);
        alquilerRepository.save(nuevoAlquiler);
        return nuevoAlquiler;
    }
    /*Método escrito para realizar la primera parte del alquiler*/
    public Alquiler alquilerEnProceso (Equipo primerEquipoAlquiler, Cliente clienteActual,Date fechaEsperada,
                                       int cantidad){
        /*TODO: Verificar estado una vez se crea en la bd al momento de fallar el alquiler.*/
        Estado enProceso = estadoRepository.findById(4L).get();
        Alquiler alquilerParcial = new Alquiler(clienteActual, enProceso, fechaEsperada);
        Set<Equipo> misEquipos = new HashSet<>();
        misEquipos.add(primerEquipoAlquiler);
        alquilerRepository.save(alquilerParcial);
        /*Solución propuesta para la persistencia de la cantidad de equipos a ser alquilados.*/
        AlquilerEquipo alquilerEquipo = new AlquilerEquipo(primerEquipoAlquiler, alquilerParcial, cantidad);
        alquilerEquipoRepository.save(alquilerEquipo);
        alquilerParcial.getEquipos().add(alquilerEquipo);
        primerEquipoAlquiler.getAlquileres().add(alquilerEquipo);
        /*TODO: Debieramos de volver a guardar los objetos, luego de modificarlos?*/
        alquilerRepository.save(alquilerParcial);
        equipoRepository.save(primerEquipoAlquiler);
        return alquilerParcial;
    }

    public Alquiler obtenerAlquiler(long id){
        Alquiler actual = alquilerRepository.findById(id).get();
        return actual;
    }
    public String getFechaDevString(long id){
        Alquiler actual = alquilerRepository.findById(id).get();
        String fecha = actual.getFechaDevolucionEsperada().toString();
        return fecha;
    }
}
