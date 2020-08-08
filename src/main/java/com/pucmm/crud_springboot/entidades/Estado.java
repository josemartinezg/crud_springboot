package com.pucmm.crud_springboot.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Estado implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    @OneToMany(mappedBy = "estado")
    private Set<Alquiler> alquileres;
    @OneToMany(mappedBy = "estado")
    private Set<Equipo> equipos;

    public Estado(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

}
