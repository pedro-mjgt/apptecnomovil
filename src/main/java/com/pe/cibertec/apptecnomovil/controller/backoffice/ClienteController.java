package com.pe.cibertec.apptecnomovil.controller.backoffice;
import com.pe.cibertec.apptecnomovil.model.bd.Cliente;
import com.pe.cibertec.apptecnomovil.model.dto.request.ClienteRequest;
import com.pe.cibertec.apptecnomovil.model.dto.response.ResultadoResponse;
import com.pe.cibertec.apptecnomovil.service.IClienteService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private IClienteService iClienteService;

    @GetMapping("")
    public String formliente(Model model) {
        model.addAttribute("listaclientes", iClienteService.listarClientes());
        return "backoffice/cliente/formcliente";
    }

    @GetMapping("/lista")
    @ResponseBody
    public List<Cliente> listaClientes() {
        return iClienteService.listarClientes();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarCliente(@RequestBody ClienteRequest clienteRequest) {
        String mensaje = "Cliente registrado";
        boolean respuesta = true;

        try {
            Cliente cliente = new Cliente();

            if (clienteRequest.getClienteid() > 0) {
                cliente.setClienteid(clienteRequest.getClienteid());
                mensaje = "Cliente actualizado";
            }

            cliente.setNombre(clienteRequest.getNombre());
            cliente.setDireccion(clienteRequest.getDireccion());
            cliente.setEmail(clienteRequest.getEmail());
            cliente.setTelefono(clienteRequest.getTelefono());
            cliente.setActivo(clienteRequest.getActivo());

            iClienteService.registrarCliente(cliente);
        }
        catch (Exception ex) {
            mensaje = "Cliente no registrado, error en la BD";
            respuesta = false;
        }

        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
