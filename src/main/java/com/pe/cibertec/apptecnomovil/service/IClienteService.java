package com.pe.cibertec.apptecnomovil.service;
import com.pe.cibertec.apptecnomovil.model.bd.Cliente;
import java.util.List;

public interface IClienteService {

    List<Cliente> listarClientes();
    void registrarCliente(Cliente cliente);

}
