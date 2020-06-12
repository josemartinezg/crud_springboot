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
@Table
@Entity
public class Estado implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    @OneToMany(mappedBy = "estado")
    private Set<Equipo> equipos;

    public Estado(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

}
