package com.miktl.peliculas.controller;

import com.miktl.peliculas.dao.IGeneroRepository;
import com.miktl.peliculas.entity.Genero;
import com.miktl.peliculas.service.IGeneroService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneroController {

    private IGeneroService generoService;

    public GeneroController(IGeneroService generoService) {
        this.generoService=generoService;
    }
    @PostMapping("genero")
    public Long guardar(@RequestParam String nombre) {
        Genero genero= new Genero();
        genero.setNombre(nombre);
        generoService.save(genero);
        return genero.getId();
    }

    @GetMapping("genero/{id}")
    public String buscarPorId(@PathVariable(name = "id") Long id) {
        return generoService.findById(id).getNombre();
    }

}
