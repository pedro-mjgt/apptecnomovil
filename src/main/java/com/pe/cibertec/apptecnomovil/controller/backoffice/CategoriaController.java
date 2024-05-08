package com.pe.cibertec.apptecnomovil.controller.backoffice;

import com.pe.cibertec.apptecnomovil.model.bd.Categoria;
import com.pe.cibertec.apptecnomovil.service.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private ICategoriaService iCategoriaService;

    @GetMapping("/get")
    @ResponseBody
    public List<Categoria> listaCategorias() {
        return iCategoriaService.listarCategorias();
    }

}
