package com.pe.cibertec.apptecnomovil.service;

import com.pe.cibertec.apptecnomovil.model.bd.Cliente;
import com.pe.cibertec.apptecnomovil.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {return clienteRepository.findAll();}

    @Override
    public void registrarCliente(Cliente cliente) {clienteRepository.save(cliente);}

}
