package com.isa.morswiny.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "favourites",
            joinColumns = @JoinColumn(name = "userId",referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "eventId",referencedColumnName = "eventId"))
    private Set<Event> favourites = new HashSet<>();

    public User () {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<Event> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<Event> favourites) {
        this.favourites = favourites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                getUserType() == user.getUserType() &&
                Objects.equals(getFavourites(), user.getFavourites());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getSurname(), getEmail(), getPassword(), getUserType(), getFavourites());
    }
}
