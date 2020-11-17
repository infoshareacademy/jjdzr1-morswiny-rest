package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Place;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@ApplicationScoped
public class PlaceDao implements Dao<Place>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Place place) {
        entityManager.persist(place);
    }

    @Override
    public Place update(Place place) {

        return entityManager.merge(place);
    }

    @Override
    public void delete(Place place) {
        entityManager.remove(place);
    }

    @Override
    public Optional<Place> find(Integer id) {

        return Optional.ofNullable(entityManager.find(Place.class, id));
    }
}
