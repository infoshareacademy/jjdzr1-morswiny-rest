package com.isa.morswiny.Dao;


import com.isa.morswiny.model.EventURL;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;

@SessionScoped
public class EventURLDao implements Dao<EventURL>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(EventURL eventURL) {

        entityManager.persist(eventURL);
    }

    @Override
    public EventURL update(EventURL eventURL) {

        return entityManager.merge(eventURL);
    }

    @Override
    public void delete(EventURL eventURL) {
        entityManager.remove(eventURL);
    }

    @Override
    public Optional<EventURL> find(Integer id) {
        return Optional.ofNullable(entityManager.find(EventURL.class, id));
    }
}
