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
    private int id;
    private String nombre;
    @OneToMany
    private Set<Equipo> equipos;
}
