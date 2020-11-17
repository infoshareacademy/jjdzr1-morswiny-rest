package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.Dao.FavouritesDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class FavouritesService {

    @Inject
    private FavouritesDao favouritesDao;


    public Set<Event> getAllFavouritesForUser(Integer userId){
        return favouritesDao.getFavouritesForUserId(userId);
    }

    public UserDto getUserByEmail(String email){
        if(favouritesDao.getByEmail(email) == null){
            return null;
        }else{
            return UserService.userToDto(favouritesDao.getByEmail(email));
        }
    }

    public static EventDto provideEventDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setName(event.getName());
        eventDto.setEventId(event.getEventId());
        eventDto.setDescLong(event.getDescLong());
        eventDto.setCategoryId(event.getCategoryId());
        eventDto.setStartDate(event.getStartDate());
        eventDto.setEndDate(event.getEndDate());
        eventDto.setPlace(event.getPlace());
        eventDto.setUrls(event.getUrls());
        eventDto.setAttachments(event.getAttachments());
        eventDto.setOrganizer(event.getOrganizer());

        return eventDto;
    }

    public static Event provideEvent(EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setEventId(eventDto.getEventId());
        event.setDescLong(eventDto.getDescLong());
        event.setCategoryId(eventDto.getCategoryId());
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setPlace(eventDto.getPlace());
        event.setUrls(eventDto.getUrls());
        event.setAttachments(eventDto.getAttachments());
        event.setOrganizer(eventDto.getOrganizer());

        return event;
    }

    public static UserDto userToDto (User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getUserId());
        userDto.setPassword(user.getPassword());
        userDto.setUserType(user.getUserType());
        if (user.getName() != null) {
            userDto.setName(user.getName());
        }
        if (user.getSurname() != null) {
            userDto.setSurname(user.getSurname());
        }
        if (user.getFavourites() != null) {
            userDto.setFavourites(user.getFavourites());
        }

        return userDto;
    }

    public static User dtoToUser (UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUserId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setUserType(userDto.getUserType());
        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getSurname() != null) {
            user.setSurname(userDto.getSurname());
        }
        if (userDto.getFavourites() != null) {
            user.setFavourites(userDto.getFavourites());
        }

        return user;
    }



    //official
    public UserDto addToFavourites(Integer userId, EventDto event){
        UserDto userDto = userToDto(favouritesDao.getUser(userId));
        Event eventFromDto = provideEvent(event);
        Set<Event> favourites = userDto.getFavourites();
        favourites.add(eventFromDto);
        userDto.setFavourites(favourites);
        User user = dtoToUser(userDto);
        favouritesDao.addFavouriteEvent(user);
        return userDto;
    }

    //official
    public UserDto removeFromFavourite(Integer userId, EventDto event){
        UserDto userDto = userToDto(favouritesDao.getUser(userId));
        Event eventFromDto = provideEvent(event);
        Set<Event> favourites = userDto.getFavourites();
        favourites.remove(eventFromDto);
        userDto.setFavourites(favourites);
        User user = dtoToUser(userDto);
        favouritesDao.addFavouriteEvent(user);
        return userDto;
    }




}
