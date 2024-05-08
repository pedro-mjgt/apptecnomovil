package com.pe.cibertec.apptecnomovil.controller.backoffice;

import com.pe.cibertec.apptecnomovil.model.bd.Marca;
import com.pe.cibertec.apptecnomovil.service.IMarcaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/marca")
public class MarcaController {

    private IMarcaService iMarcaService;

    @GetMapping("/get")
    @ResponseBody
    public List<Marca> listaMarcas() {
        return iMarcaService.listarMarcas();
    }

}
