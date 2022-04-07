package com.articulos.demo.servicios.impl;
import com.articulos.demo.entidades.ArticuloEntidad;



import com.articulos.demo.repositorios.ArticuloRepositorio;
import com.articulos.demo.servicios.ArticuloServicio;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServicioImpl implements ArticuloServicio {

    @Autowired
    private ArticuloRepositorio articuloRepositorio;



    private static Logger log = Logger.getLogger(ArticuloServicioImpl.class);

    public Object articuloEntidad(String[] campo) {
        if (campo.length == 5) {
            ArticuloEntidad entidad = new ArticuloEntidad();
            entidad.setId(campo[0]);
            entidad.setMarca(campo[1]);
            entidad.setDescripcion(campo[2]);
            entidad.setUnidades(campo[3]);
            entidad.setPrecio(campo[4]);
            return articuloRepositorio.save(entidad);
        } else {
            log.error("Revise el archivo de carga, no se guardo este producto porque le faltan campos. Producto:  " + campo[0]);

            return null;
        }
    }

        public List<ArticuloEntidad> listaArticulos(){

            return articuloRepositorio.findAll();
        }
    }



