package com.miktl.peliculas.service.pelicula;

import com.miktl.peliculas.entity.Pelicula;

import java.util.List;
import java.util.Optional;

public interface IPeliculaService {
    public void save(Pelicula pelicula);

    public Optional<Pelicula> findById(Long id);

    public void deleteById(Long id);

    public List<Pelicula> findAll();
}
