package com.miktl.peliculas.dao;

import com.miktl.peliculas.entity.Genero;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IGeneroRepository extends CrudRepository<Genero,Long> {
}
