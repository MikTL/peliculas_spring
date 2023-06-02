package com.miktl.peliculas.service.actor;

import com.miktl.peliculas.dao.IActorRepository;
import com.miktl.peliculas.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActorService implements IActorService {
    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public List<Actor> findAllById(List<Long> ids) {
        return (List<Actor>) actorRepository.findAllById(ids);
    }
}
