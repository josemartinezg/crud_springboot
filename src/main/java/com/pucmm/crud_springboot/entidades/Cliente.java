package com.pucmm.crud_springboot.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Base64;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String apellido;
    private String cedula;
    @Column(name = "foto_perfil", length = 1000000)
    private String fotoDePeril;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Alquiler> misAlquileres;

    public Cliente(String nombre, String apellido, String cedula, String fotoDePeril) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fotoDePeril = fotoDePeril;
    }
    public Cliente(long id, String nombre, String apellido, String cedula, String fotoDePeril) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fotoDePeril = fotoDePeril;
    }


}
