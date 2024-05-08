package com.pe.cibertec.apptecnomovil.service;

import com.pe.cibertec.apptecnomovil.model.bd.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> listarProductos();
    void registrarProducto(Producto producto);

}
