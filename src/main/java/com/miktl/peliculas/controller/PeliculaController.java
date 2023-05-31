package com.miktl.peliculas.controller;

import com.miktl.peliculas.entity.Actor;
import com.miktl.peliculas.entity.Pelicula;
import com.miktl.peliculas.service.actor.IActorService;
import com.miktl.peliculas.service.genero.IGeneroService;
import com.miktl.peliculas.service.pelicula.IPeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PeliculaController {
    private IPeliculaService service;
    private IGeneroService generoService;
    private IActorService actorService;

    public PeliculaController(
            IPeliculaService service,
            IGeneroService generoService,
            IActorService actorService
    ) {
        this.service=service;
        this.generoService=generoService;
        this.actorService = actorService;
    }
    @GetMapping("/pelicula")
    public String  crear(Model model){
        Pelicula pelicula= new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo","Nueva pelicula");
        return "pelicula";
    }
    @GetMapping("pelicula/{id}")
    public String  editar(@PathVariable(name = "id") Long id, Model model){
        Pelicula pelicula= new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo","Editar película");
        return "pelicula";
    }

    @GetMapping({"/home", "/", "/index"})
    public String home() {
        return "home";
    }

    @PostMapping("/pelicula")
    public String guardar(Pelicula pelicula, @ModelAttribute(name = "ids") String ids) {
        List<Long> idsProtagonistas = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        List<Actor> protagonistas = actorService.findAllById(idsProtagonistas);
        pelicula.setProtagonistas(protagonistas);
        service.save(pelicula);
        return "redirect:/home";
    }
}
