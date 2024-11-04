package com.prueba_1.service;

import com.prueba_1.domain.Publicacion;
import java.util.List;

public interface PublicacionService {
    Publicacion save(Publicacion publicacion);
    Publicacion findById(int id);
    List<Publicacion> findAll();
    void deleteById(int id);
}