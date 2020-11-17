package com.isa.morswiny.services;

import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.model.User;
import com.isa.morswiny.Dao.UserDao;
import com.isa.morswiny.model.UserType;
import com.isa.morswiny.servlets.AddUserServlet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserService {

    private static final String ADMIN_PASSWORD = "admin";
    @Inject
    UserDao userDao;

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

    public static User updateDtoToUser (UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserType(userDto.getUserType());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());

        return user;
    }

    public UserDto getUserDto(Integer id) {
        return userToDto(userDao.getUser(id));
    }

    public List<UserDto> getAll() {
        return userDao.getAll().stream()
                .map(UserService::userToDto)
                .collect(Collectors.toList());
    }

    public UserDto getByEmail(String email) {
        if (userDao.getByEmail(email) == null) {
            return null;
        } else {
            return userToDto(userDao.getByEmail(email));
        }
    }

    public UserDto save(UserDto userDto) {
       User user = userDao.save(dtoToUser(userDto));
       return userToDto(user);
    }

    public void delete(UserDto userDto) {
        userDao.delete(dtoToUser(userDto));
    }

    public UserDto update(Integer id, UserDto userDto) {
        User user = userDao.update(id, updateDtoToUser(userDto));
        return userToDto(user);
    }

    public void createAdmin() {
        String adminPassword = Integer.toString(ADMIN_PASSWORD.hashCode());
        UserDto adminUser = AddUserServlet.createUser("Admin", "Admin", "admin@morswiny.pl", adminPassword);
        adminUser.setUserType(UserType.ADMIN);
        save(adminUser);
    }

}
