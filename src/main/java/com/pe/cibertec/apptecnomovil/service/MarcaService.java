package com.pe.cibertec.apptecnomovil.service;

import com.pe.cibertec.apptecnomovil.model.bd.Marca;
import com.pe.cibertec.apptecnomovil.repository.MarcaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MarcaService implements IMarcaService {

    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

}
