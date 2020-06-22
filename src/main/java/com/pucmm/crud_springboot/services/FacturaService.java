package com.pucmm.crud_springboot.services;

import com.pucmm.crud_springboot.entidades.Factura;
import com.pucmm.crud_springboot.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> getAllFacturas(){
        List <Factura> facturas = facturaRepository.findAll();
        return facturas;
    }

    public List<Factura> getAlquilerByEstado(long id){
        List<Factura> facturas = facturaRepository.findAllByAlquiler_Estado_IdOrderByFechaFacturacion(id);
        return facturas;
    }

    public List<Factura> getAlquilerByCliente(long id){
        List<Factura> facturas = facturaRepository.findAllByAlquiler_ClienteId(id);
        return facturas;
    }
}
