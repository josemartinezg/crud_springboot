package com.pucmm.crud_springboot.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fecha_facturacion")
    private Date fechaFacturacion;
    @Column(name = "total_facturado")
    private float totalFacturado;
    @ManyToOne(fetch = FetchType.LAZY)
    private Alquiler alquiler;

    public Factura(Date fechaFacturacion, float totalFacturado, Alquiler alquiler){
        this.fechaFacturacion = fechaFacturacion;
        this.totalFacturado = totalFacturado;
        this.alquiler = alquiler;
    }
}
