package com.isa.morswiny.Dao;


import com.isa.morswiny.model.Organizer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@ApplicationScoped
public class OrganizerDao implements Dao<Organizer> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Organizer organizer) {
        entityManager.persist(organizer);
    }

    @Override
    public Organizer update(Organizer organizer) {
       return entityManager.merge(organizer);
    }

    @Override
    public void delete(Organizer organizer) {
        entityManager.remove(organizer);
    }

    @Override
    public Optional<Organizer> find(Integer id) {
        return Optional.ofNullable(entityManager.find(Organizer.class, id));

    }
}
