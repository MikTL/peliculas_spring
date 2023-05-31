package com.miktl.peliculas.dao;

import com.miktl.peliculas.entity.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Long> {
}
