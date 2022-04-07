package com.articulos.demo.repositorios;



import com.articulos.demo.entidades.ArticuloEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepositorio extends JpaRepository<ArticuloEntidad, String> {

}

