package com.miktl.peliculas.dao;

import com.miktl.peliculas.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface IActorRepository extends CrudRepository<Actor,Long> {
}
