package com.pe.cibertec.apptecnomovil.service;

import com.pe.cibertec.apptecnomovil.model.bd.Categoria;
import com.pe.cibertec.apptecnomovil.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaService implements ICategoriaService {

    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
}
