package com.miktl.peliculas.service.pelicula;

import com.miktl.peliculas.dao.IPeliculaRepository;
import com.miktl.peliculas.entity.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PeliculaService implements IPeliculaService {
    @Autowired
    IPeliculaRepository peliRepo;

    @Override
    public void save(Pelicula pelicula) {
        peliRepo.save(pelicula);
    }

    @Override
    public Optional<Pelicula> findById(Long id) {
        return peliRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        peliRepo.deleteById(id);
    }

    @Override
    public List<Pelicula> findAll() {
        return (List<Pelicula>) peliRepo.findAll();
    }
}
