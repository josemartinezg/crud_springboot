package com.pucmm.crud_springboot.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AlquilerEquipo  implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Alquiler alquiler;
    @ManyToOne
    private Equipo equipo;
    private int cantidad;

    public AlquilerEquipo(Equipo equipo, Alquiler alquiler, int cantidad) {
        this.equipo = equipo;
        this.alquiler = alquiler;
        this.cantidad = cantidad;
    }
}

