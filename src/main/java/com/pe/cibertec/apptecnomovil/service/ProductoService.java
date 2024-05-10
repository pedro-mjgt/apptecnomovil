package com.pe.cibertec.apptecnomovil.service;

import com.pe.cibertec.apptecnomovil.model.bd.Producto;
import com.pe.cibertec.apptecnomovil.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductoService implements IProductoService {

    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void registrarProducto(Producto producto) {
        productoRepository.save(producto);
    }

}
