package com.isa.morswiny.servlets;

import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.model.UserType;
import com.isa.morswiny.services.ServletService;
import com.isa.morswiny.services.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet("/profile")
public class MyProfileServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "my-profile";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> map = new HashMap<>();
        ServletService.sessionValidation(req, map);

        if (!map.containsKey("logged")){
            resp.sendRedirect("/login");
        }

        UserDto userLogged = getUserData((String) req.getSession().getAttribute("logged"));
        map.put("User", userLogged);

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, Object> map = new HashMap<>();

        ServletService.sessionValidation(req, map);

        UserDto userLogged = getUserData((String) req.getSession().getAttribute("logged"));

        String email = userLogged.getEmail();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String passwordForm = req.getParameter("password");
        String password;


        if (name.isEmpty()) {
            name = userLogged.getName();
        }
        if (surname.isEmpty()) {
            surname = userLogged.getSurname();
        }
        password = (passwordForm.isEmpty()) ? userLogged.getPassword() : Integer.toString(passwordForm.hashCode());

        UserDto userChanged = createUser(name, surname, email, password);
        userService.update(userLogged.getId(), userChanged);

        resp.sendRedirect("/profile");
    }

    public static UserDto createUser(String name, String surname, String email, String password){
        UserDto userDto = new UserDto();
        if (name != null){
            userDto.setName(name);
        }
        if (surname != null){
            userDto.setSurname(surname);
        }
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setUserType(UserType.STANDARD_USER);
        userDto.setFavourites(new HashSet<>());

        return userDto;
    }

    private UserDto getUserData(String email){
        return userService.getByEmail(email);
    }
}
