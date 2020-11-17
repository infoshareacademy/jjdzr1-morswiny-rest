package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.User;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestScoped
@Transactional
public class FavouritesDao {

    @PersistenceContext
    EntityManager entityManager;


    //official
    public User addFavouriteEvent(User user){
        entityManager.merge(user);
        return user;
    }

    //official
    public User removeFavouriteEvent(User user){
        entityManager.merge(user);
        return user;
    }

    public Set<Event> getFavouritesForUserId(Integer id) {
        TypedQuery<User> userQuery = entityManager.createQuery(
                "SELECT u FROM User u WHERE userId = :id", User.class);
        userQuery.setParameter("id", id);
        User user = userQuery.getSingleResult();
        Set<Event> events = user.getFavourites();
        return events;
    }

    public Event find(Integer id) {
        return entityManager.find(Event.class, id);
    }

    public User getByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

}
