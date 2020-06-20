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
        /*TODO: Verificar si hay suficientes equipos en stock para realizar la transacción.*/
        Estado enProceso = estadoRepository.findById(4L).get();
        Alquiler alquilerParcial = new Alquiler(clienteActual, enProceso, fechaEsperada);
        alquilerRepository.save(alquilerParcial);
        /*Solución propuesta para la persistencia de la cantidad de equipos a ser alquilados.*/
        AlquilerEquipo alquilerEquipo = new AlquilerEquipo(primerEquipoAlquiler, alquilerParcial, cantidad);
        Set<AlquilerEquipo> equipos = new HashSet<>();
        equipos.add(alquilerEquipo);
        alquilerEquipoRepository.save(alquilerEquipo);
        alquilerParcial.setEquipos(equipos);
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

    public AlquilerEquipo agregarEquipo(long idAlquiler, long idEquipo, int cantidad){
        Equipo nuevoEquipo = equipoRepository.findById(idEquipo).get();
        Alquiler alquilerActual = obtenerAlquiler(idAlquiler);
        AlquilerEquipo nuevaRelacion = new AlquilerEquipo(nuevoEquipo, alquilerActual, cantidad);
        nuevoEquipo.getAlquileres().add(nuevaRelacion);
        alquilerActual.getEquipos().add(nuevaRelacion);

        alquilerEquipoRepository.save(nuevaRelacion);
        equipoRepository.save(nuevoEquipo);
        alquilerRepository.save(alquilerActual);
        return nuevaRelacion;
    }

    public Alquiler finalizarAlquiler(long id){
        Alquiler alquiler = obtenerAlquiler(id);
        Estado alquilado = estadoRepository.findById(1L).get();
        alquiler.setEstado(alquilado);
        alquiler.setFechaDeAlquiler(new Date(System.currentTimeMillis()));
        alquilerRepository.save(alquiler);
        return alquiler;
    }
}
