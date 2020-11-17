package com.isa.morswiny.Dao;

import com.isa.morswiny.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getAll() {
        Query all = entityManager.createQuery("FROM User");
        return (List<User>) all.getResultList();
    }

    public User getByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
        List<User> user = query.setParameter("email", email).getResultList();
        if (user.isEmpty()){
            return null;
        } else {
            return user.get(0);
        }
    }

    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    public User update(Integer id, User user) {

        User userFound = entityManager.find(User.class, id);
        userFound.setEmail(user.getEmail());
        userFound.setPassword(user.getPassword());
        userFound.setSurname(user.getSurname());
        if (user.getName() != null) {
            userFound.setName(user.getName());
        }
        if (user.getUserType() != null) {
            user.setUserType(user.getUserType());
        }
        if (user.getFavourites() != null) {
            userFound.setFavourites(user.getFavourites());
        }

        entityManager.merge(userFound);
        return userFound;
    }
}
