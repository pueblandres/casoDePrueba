package com.articulos.demo.controladores;

import com.articulos.demo.entidades.ArticuloEntidad;
import com.articulos.demo.servicios.ArticuloServicio;
import com.articulos.demo.servicios.LeerArchivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("articulos")
public class ArticuloControlador {


    @Autowired
    private LeerArchivo leerArchivo;

    @Autowired
    private ArticuloServicio articuloServicio;




    @PostMapping()
    public String leer(@RequestParam MultipartFile archivo, ModelMap modelo) {
        try {
            leerArchivo.leer(archivo);
            modelo.put("exito", "se cargaron los productos. Ver productos");
            return "exito";
        } catch (IOException e) {
            modelo.put("error",e.getMessage());
            return "exito";
        }
    }

    @GetMapping("/verArticulos")
    public String usuarios(ModelMap modelo) {

        List<ArticuloEntidad> articulos = articuloServicio.listaArticulos();
        modelo.addAttribute("articulo", articulos);

        return "articulos";
    }

    @GetMapping("/verErrores")
    public String erroresCarga(ModelMap modelo) {


        return "ErroresCarga";
    }
}
