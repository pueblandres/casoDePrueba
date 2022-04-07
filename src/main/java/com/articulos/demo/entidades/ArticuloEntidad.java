package com.articulos.demo.entidades;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "Articulos")
@Getter
@Setter
public class ArticuloEntidad {

    @Id
    private String id;

    private String marca;

    private String descripcion;

    private String unidades;

    private String precio;

}
