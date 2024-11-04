package com.prueba_1.dao;

import com.prueba_1.domain.Publicacion;
import org.springframework.data.repository.CrudRepository;

public interface PublicacionDao extends CrudRepository<Publicacion, Integer> {
}