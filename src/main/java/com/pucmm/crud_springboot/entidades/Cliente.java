package com.pucmm.crud_springboot.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
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
    @Column(name = "foto_perfil")
    private String fotoDePeril;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Alquiler> misAlquileres;
}
