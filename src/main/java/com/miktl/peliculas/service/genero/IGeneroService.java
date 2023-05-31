package com.miktl.peliculas.service.genero;
import com.miktl.peliculas.entity.Genero;
public interface IGeneroService {
    public void save(Genero genero);

    public Genero findById(Long id);

    public void delete(Long id);

    public Iterable<Genero> findAll();
}
