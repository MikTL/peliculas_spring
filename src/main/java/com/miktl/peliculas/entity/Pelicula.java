package com.miktl.peliculas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "Pelicula")
@Table(name = "peliculas")
public class Pelicula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no debe estar vacío")
    private String nombre;

    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha es obligatoria")
    @Past
    private Date fechaEstreno;
    @NotNull(message = "Debe seleccionar algún género")
    @OneToOne
    private Genero genero;
    @NotNull(message = "Debe seleccionar los actores")
    @ManyToMany
    private List<Actor> protagonistas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Actor> getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(List<Actor> protagonistas) {
        this.protagonistas = protagonistas;
    }
}
