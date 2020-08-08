package com.pucmm.crud_springboot.services;

import ch.qos.logback.core.net.server.Client;
import com.pucmm.crud_springboot.entidades.Cliente;
import com.pucmm.crud_springboot.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public List<Cliente> getAllClients(){
        List<Cliente> misClientes = clienteRepository.findAll();
        return misClientes;
    }

    @Transactional
    public Cliente obtenerCliente(long id){
        Cliente clienteActual = clienteRepository.findById(id).get();
        return clienteActual;
    }
}


