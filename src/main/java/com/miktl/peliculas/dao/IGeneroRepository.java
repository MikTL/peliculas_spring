package com.miktl.peliculas.dao;

import com.miktl.peliculas.entity.Genero;

public interface IGeneroRepository {
    public void save(Genero genero);

    public Genero findById(Long id);
}
