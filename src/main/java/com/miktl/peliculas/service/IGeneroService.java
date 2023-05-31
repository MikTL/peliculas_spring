package com.miktl.peliculas.service;

import com.miktl.peliculas.entity.Genero;
import org.springframework.stereotype.Service;


public interface IGeneroService {
    public void save(Genero genero);

    public Genero findById(Long id);

    public void delete(Long id);

    public Iterable<Genero> findAll();
}
