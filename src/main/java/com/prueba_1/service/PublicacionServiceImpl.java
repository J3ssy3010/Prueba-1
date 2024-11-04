package com.prueba_1.service;

import com.prueba_1.dao.PublicacionDao;
import com.prueba_1.domain.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionDao publicacionDao;

    @Override
    public Publicacion save(Publicacion publicacion) {
        return publicacionDao.save(publicacion);
    }

    @Override
    public Publicacion findById(int id) {
        return publicacionDao.findById(id).orElse(null);
    }

    @Override
    public List<Publicacion> findAll() {
        return (List<Publicacion>) publicacionDao.findAll();
    }

    @Override
    public void deleteById(int id) {
        publicacionDao.deleteById(id);
    }
}