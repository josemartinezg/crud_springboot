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
    public void actualizaEquipo(long id, Equipo equipoModificado){
        Equipo equipoActual = equipoRepository.getOne(id);
        equipoActual.setMarca(equipoModificado.getMarca());
        equipoActual.setModelo(equipoModificado.getModelo());
        equipoActual.setDescripcion(equipoModificado.getDescripcion());
        equipoActual.setCostoAlquilerDiario(equipoModificado.getCostoAlquilerDiario());
        equipoActual.setImagenEquipo(equipoModificado.getImagenEquipo());
        equipoActual.setCantidadEnExistencia(equipoModificado.getCantidadEnExistencia());
        equipoActual.setSubFamiliaDeEquipos(equipoModificado.getSubFamiliaDeEquipos());
        equipoRepository.save(equipoActual);
    }

    @Transactional
    public void eliminarEquipo(long id){
        Equipo equipoActual = equipoRepository.getOne(id);
        equipoRepository.delete(equipoActual);
    }

}
