package com.pucmm.crud_springboot.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue
    @Column
    private int matricula;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String telefono;
}
