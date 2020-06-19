package com.pucmm.crud_springboot.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "familia_equipo")
public class FamiliaEquipo implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "familiaEquipo", cascade = CascadeType.ALL)
    private Set<SubFamiliaEquipo> listaSubFamilias;

}
