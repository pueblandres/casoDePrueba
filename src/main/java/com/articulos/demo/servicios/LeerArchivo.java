package com.articulos.demo.servicios;



import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface LeerArchivo {

     void leer(MultipartFile archivo) throws IOException;

}
