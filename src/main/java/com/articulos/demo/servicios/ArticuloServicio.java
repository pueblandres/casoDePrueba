package com.articulos.demo.servicios;

import com.articulos.demo.entidades.ArticuloEntidad;


import java.util.List;

public interface ArticuloServicio {

     Object articuloEntidad(String[] entidades);

      List<ArticuloEntidad> listaArticulos();
}
