package com.pucmm.crud_springboot.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Equipo implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String marca;
    private String modelo;
    private String descripcion;
    @Column(name="costo_alquiler_diario")
    private float costoAlquilerDiario;
    /*Se define como TEXT para poder guardar el archivo base 64 completo.*/
    @Column(name="imagen_equipo", columnDefinition = "TEXT")
    private String imagenEquipo;
    @Column(name="cantidad_existencia")
    private int cantidadEnExistencia;
    @ManyToMany
    private Set<Alquiler> listaDeAlquileres;
    @ManyToOne(fetch = FetchType.LAZY)
    private SubFamiliaEquipo subFamiliaDeEquipos;

    public Equipo(String marca, String modelo, String descripcion,
                  float costo, String imagen, int existencia, SubFamiliaEquipo familia) {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.costoAlquilerDiario = costo;
        this.imagenEquipo = imagen;
        this.cantidadEnExistencia = existencia;
        this.subFamiliaDeEquipos = familia;

    }

    public Equipo(String marca, String modelo, String descripcion,
                  float costo, int existencia, SubFamiliaEquipo familia) {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.costoAlquilerDiario = costo;
        this.cantidadEnExistencia = existencia;
        this.subFamiliaDeEquipos = familia;

    }
    public Equipo(String marca, String modelo,
                  float costo, int existencia, SubFamiliaEquipo familia) {
        this.marca = marca;
        this.modelo = modelo;
        this.costoAlquilerDiario = costo;
        this.cantidadEnExistencia = existencia;
        this.subFamiliaDeEquipos = familia;

    }

    public int aumentarExistencia(){
        return 0;
    }

    public int disminuirExistencia(){
        return 0;
    }

    public int verificarCantidadExistencia(){
        return 0;
    }
}



