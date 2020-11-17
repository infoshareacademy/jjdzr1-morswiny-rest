package com.isa.morswiny.Dao;


import com.isa.morswiny.model.Attachment;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;


@ApplicationScoped
public class AttachmentDao implements Dao<Attachment>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Attachment attachment) {
        entityManager.persist(attachment);
    }


    @Override
    public Attachment update(Attachment attachment) {
        return entityManager.merge(attachment);

    }

    @Override
    public void delete(Attachment attachment) {
        entityManager.remove(attachment);

    }

    @Override
    public Optional<Attachment> find(Integer id) {
        return Optional.ofNullable(entityManager.find(Attachment.class, id));
    }
}
