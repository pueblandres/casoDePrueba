package com.articulos.demo.servicios.impl;



import com.articulos.demo.servicios.ArticuloServicio;
import com.articulos.demo.servicios.LeerArchivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class LeerArchivoImpl implements LeerArchivo {

    public static final String SEPARADOR = ",";

    private String subirArchivo=".//src//main//resources//archivos//";

    @Autowired
    private ArticuloServicio articuloServicio;

    public void leer(MultipartFile archivo) throws IOException {

        subirArchivo(archivo);

        BufferedReader bufferLectura = null;
        try {
            bufferLectura = new BufferedReader(new FileReader(subirArchivo+ archivo.getOriginalFilename()));
            String linea = bufferLectura.readLine();

           while (linea != null) {
                String[] campos = linea.split(SEPARADOR);

                articuloServicio.articuloEntidad(campos);

               linea = bufferLectura.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    public void subirArchivo(MultipartFile archivo) throws IOException {
        if(!archivo.isEmpty()){
            byte[] bytes= archivo.getBytes();
            Path path= Paths.get(subirArchivo+ archivo.getOriginalFilename());
            Files.write(path,bytes);
        }
    }
}




