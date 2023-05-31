package com.miktl.peliculas.service.actor;

import com.miktl.peliculas.entity.Actor;

import java.util.List;

public interface IActorService {
    public List<Actor> findAll();

    public List<Actor> findAllById(List<Long> ids);
}
