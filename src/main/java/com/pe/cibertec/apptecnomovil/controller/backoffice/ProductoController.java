package com.pe.cibertec.apptecnomovil.controller.backoffice;

import com.pe.cibertec.apptecnomovil.model.bd.Categoria;
import com.pe.cibertec.apptecnomovil.model.bd.Marca;
import com.pe.cibertec.apptecnomovil.model.bd.Producto;
import com.pe.cibertec.apptecnomovil.model.dto.request.ProductoRequest;
import com.pe.cibertec.apptecnomovil.model.dto.response.ResultadoResponse;
import com.pe.cibertec.apptecnomovil.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductoController {

    private IProductoService iProductoService;

    @GetMapping("")
    public String formProducto(Model model) {
        model.addAttribute("listaproductos", iProductoService.listarProductos());
        return "backoffice/producto/formproducto";
    }

    @GetMapping("/lista")
    @ResponseBody
    public List<Producto> listaProductos() {
        return iProductoService.listarProductos();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registrarProdcuto(@RequestBody ProductoRequest productoRequest) {
        String mensaje = "Producto registrado";
        boolean respuesta = true;

        try {
            Producto producto = new Producto();

            if (productoRequest.getProductoid() > 0) {
                producto.setProductoid(productoRequest.getProductoid());
                mensaje = "Producto actualizado";
            }

            producto.setNombre(productoRequest.getNombre());
            producto.setPrecio(productoRequest.getPrecio());
            producto.setStock(productoRequest.getStock());
            producto.setActivo(productoRequest.getActivo());
            Categoria categoria = new Categoria();
            categoria.setCategoriaid(productoRequest.getCategoriaid());
            producto.setCategoria(categoria);
            Marca marca = new Marca();
            marca.setMarcaid(productoRequest.getMarcaid());
            producto.setMarca(marca);

            iProductoService.registrarProducto(producto);
        }
        catch (Exception ex) {
            mensaje = "Producto no registrado, error en la BD";
            respuesta = false;
        }

        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
