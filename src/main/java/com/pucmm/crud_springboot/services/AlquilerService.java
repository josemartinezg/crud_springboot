package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.*;
import com.pucmm.crud_springboot.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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
    @Autowired
    private FacturaRepository facturaRepository;
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
        int cantidadExistencia = primerEquipoAlquiler.getCantidadEnExistencia();
        primerEquipoAlquiler.setCantidadEnExistencia(cantidadExistencia - cantidad);
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
    public String getStdFecha(){
        long dayInMillis = 86400000;
        String fecha = new Date(System.currentTimeMillis()+dayInMillis).toString();
        return fecha;
    }

    public AlquilerEquipo agregarEquipo(long idAlquiler, long idEquipo, int cantidad){
        Equipo nuevoEquipo = equipoRepository.findById(idEquipo).get();
        Alquiler alquilerActual = obtenerAlquiler(idAlquiler);
        int cantidadExistencia = nuevoEquipo.getCantidadEnExistencia();
        AlquilerEquipo nuevaRelacion = new AlquilerEquipo(nuevoEquipo, alquilerActual, cantidad);
        nuevoEquipo.setCantidadEnExistencia(cantidadExistencia - cantidad);
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
        generarFactura(alquiler);
        alquilerRepository.save(alquiler);
        return alquiler;
    }

    public void generarFactura(Alquiler alquiler){
        Set<Factura> facturas = new HashSet<>();
        float total = 0;
        for (AlquilerEquipo relacion : alquiler.getEquipos()){
            total = total + relacion.getCantidad() * relacion.getEquipo().getCostoAlquilerDiario();
        }
        Factura factura = new Factura(new Date(System.currentTimeMillis()), total, alquiler);
        facturaRepository.save(factura);
        facturas.add(factura);
        alquiler.setFacturas(facturas);
//        alquilerRepository.save(alquiler);
    }
    public Set<Factura> generarFacturas(){
        Set<Factura> facturas = new HashSet<>();
        for (Alquiler alquiler : alquilerRepository.findAll()){
            float total = 0;
            for (AlquilerEquipo relacion : alquiler.getEquipos()){
                total = total + relacion.getCantidad() * relacion.getEquipo().getCostoAlquilerDiario();
            }
            Factura factura = new Factura(new Date(System.currentTimeMillis()), total, alquiler);
            facturaRepository.save(factura);
            facturas.add(factura);
        }
        return facturas;
    }
}
