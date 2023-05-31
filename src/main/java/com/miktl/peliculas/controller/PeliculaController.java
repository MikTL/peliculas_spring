package com.miktl.peliculas.controller;

import com.miktl.peliculas.dao.IPeliculaRepository;
import com.miktl.peliculas.entity.Pelicula;
import com.miktl.peliculas.service.genero.IGeneroService;
import com.miktl.peliculas.service.pelicula.IPeliculaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PeliculaController {
    private IPeliculaService service;
    private IGeneroService generoService;

    public PeliculaController(IPeliculaService service, IGeneroService generoService) {
        this.service=service;
        this.generoService=generoService;
    }
    @GetMapping("/pelicula")
    public String  crear(Model model){
        Pelicula pelicula= new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo","Nueva pelicula");
        return "pelicula";
    }
    @GetMapping("pelicula/{id}")
    public String  editar(@PathVariable(name = "id") Long id, Model model){
        Pelicula pelicula= new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo","Editar película");
        return "pelicula";
    }

    @PostMapping("/pelicula")
    public String guardar(Pelicula pelicula) {
        service.save(pelicula);
        return "redirect:/home";
    }

    @GetMapping({"/home", "/", "/index"})
    public String home() {
        return "home";
    }
}
