package com.isa.morswiny.dto;

import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.User;
import com.isa.morswiny.model.UserType;

import java.util.Objects;
import java.util.Set;

public class UserDto {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;
    private Set<Event> favourites;

    public Set<Event> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<Event> favourites) {
        this.favourites = favourites;
    }

    public UserDto () {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getUserId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                getUserType() == user.getUserType() &&
                Objects.equals(getFavourites(), user.getFavourites());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getEmail(), getPassword(), getUserType(), getFavourites());
    }
}
