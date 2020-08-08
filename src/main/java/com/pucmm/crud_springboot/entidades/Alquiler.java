package com.pucmm.crud_springboot.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Alquiler implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;
    @Column(name = "fecha_alquiler")
    private Date fechaDeAlquiler;
    @Column(name = "fecha_devolucion_esperada")
    private Date fechaDevolucionEsperada;
    @Column(name = "fecha_devolucion_real")
    private Date fechaDevolcionReal;
    //En relación ManyToMany el mappedBy puede venir de cualquier extremo de la relación.
    @OneToMany(mappedBy = "alquiler")
    Set<AlquilerEquipo> equipos;
    @OneToMany(mappedBy = "alquiler")
    Set<Factura> facturas;


    public Alquiler(Cliente cliente, Estado estado, Date fechaDevolucionEsperada) {
        this.cliente = cliente;
        this.estado = estado;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }
    public Alquiler(Cliente cliente, Estado estado, Date fechaDeAlquiler, Date fechaDevolucionEsperada) {
        this.cliente = cliente;
        this.estado = estado;
        this.fechaDeAlquiler = fechaDeAlquiler;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }
//    public Alquiler(Cliente cliente, Estado estado, Date fechaDeAlquiler, Date fechaDevolucionEsperada,
//        Set<Equipo> listaDeEquiposRentados) {
//        this.cliente = cliente;
//        this.estado = estado;
//        this.fechaDeAlquiler = fechaDeAlquiler;
//        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
//        this.listaDeEquiposRentados = listaDeEquiposRentados;
//    }
//    public Alquiler(Cliente cliente, Estado estado, Date fechaDeAlquiler, Date fechaDevolucionEsperada,
//        Date fechaDevolcionReal, Set<Equipo> listaDeEquiposRentados) {
//        this.cliente = cliente;
//        this.estado = estado;
//        this.fechaDeAlquiler = fechaDeAlquiler;
//        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
//        this.fechaDevolcionReal = fechaDevolcionReal;
//        this.listaDeEquiposRentados = listaDeEquiposRentados;
//    }

}
