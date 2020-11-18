package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Place;
import com.isa.morswiny.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    public Place findPlaceByName(String name){
        TypedQuery<Place> query = entityManager.createQuery(
                "SELECT u FROM Place u WHERE u.name = :name", Place.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
