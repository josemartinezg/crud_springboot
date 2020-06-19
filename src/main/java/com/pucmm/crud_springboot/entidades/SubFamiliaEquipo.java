package com.pucmm.crud_springboot.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sub_familia_equipo")
public class SubFamiliaEquipo implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    private FamiliaEquipo familiaEquipo;
    @OneToMany(mappedBy = "subFamiliaDeEquipos", cascade = CascadeType.ALL)
    private Set<Equipo> listaEquipos;
}
