package com.pucmm.crud_springboot.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Alquiler implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    private Estado estado;
    @Column(name = "fecha_alquiler")
    private Date fechaDeAlquiler;
    @Column(name = "fecha_devolucion_esperada")
    private Date fechaDevolucionEsperada;
    @Column(name = "fecha_devolucion_real")
    private Date fechaDevolcionReal;
    //En relación ManyToMany el mappedBy puede venir de cualquier extremo de la relación.
    @ManyToMany(mappedBy = "listaDeAlquileres", cascade = CascadeType.REMOVE)
    private Set<Equipo> listaDeEquiposRentados;


    public Alquiler(Cliente cliente, Estado estado, Date fechaDeAlquiler, Date fechaDevolucionEsperada) {
        this.cliente = cliente;
        this.estado = estado;
        this.fechaDeAlquiler = fechaDeAlquiler;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }
    public Alquiler(Cliente cliente, Estado estado, Date fechaDeAlquiler, Date fechaDevolucionEsperada,
        Set<Equipo> listaDeEquiposRentados) {
        this.cliente = cliente;
        this.estado = estado;
        this.fechaDeAlquiler = fechaDeAlquiler;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.listaDeEquiposRentados = listaDeEquiposRentados;
    }
    public Alquiler(Cliente cliente, Estado estado, Date fechaDeAlquiler, Date fechaDevolucionEsperada,
        Date fechaDevolcionReal, Set<Equipo> listaDeEquiposRentados) {
        this.cliente = cliente;
        this.estado = estado;
        this.fechaDeAlquiler = fechaDeAlquiler;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.fechaDevolcionReal = fechaDevolcionReal;
        this.listaDeEquiposRentados = listaDeEquiposRentados;
    }

}
