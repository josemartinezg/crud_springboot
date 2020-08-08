package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.*;
import com.pucmm.crud_springboot.repositorios.SFChartRepository;
import com.pucmm.crud_springboot.repositorios.SubFamiliaEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubFamiliaEquipoService {
    @Autowired
    private SubFamiliaEquipoRepository subFamiliaEquipoRepository;
    @Autowired
    private AlquilerService alquilerService;
    @Autowired
    private SFChartRepository sfChartRepository;
    public Set<SFChart> getCharts(){
        List<Alquiler> alquileres = alquilerService.obtenerAlquileres();
        Set<SFChart> charts = new HashSet<>();
        long dayInMillis = 86400000;
        for (Alquiler alquiler : alquileres){
            long inicio = alquiler.getFechaDeAlquiler().getTime();
            long fin = alquiler.getFechaDevolucionEsperada().getTime();
            int cantidadDias = (int)((fin - inicio)/dayInMillis);
            for (AlquilerEquipo equipo : alquiler.getEquipos()){
                String subFamilia = equipo.getEquipo().getSubFamiliaDeEquipos().getNombre();
                SFChart chart = new SFChart(subFamilia, cantidadDias);
                charts.add(chart);
            }
        }
        return charts;
    }

    public float calcularPromedio(){
        List<SubFamiliaEquipo> categorias = subFamiliaEquipoRepository.findAll();
        List<SFChart> charts = sfChartRepository.findAll();
        float total = 0;
        for (SubFamiliaEquipo categoria : categorias){
            String noombre = categoria.getNombre();
            for(SFChart chart : charts){
                if (chart.getCategoria().equalsIgnoreCase(noombre)) {
                    total += chart.getDias();
                    SFAverage average = new SFAverage(noombre, total);
                }
            }
        }
        return 0;
    }

}
