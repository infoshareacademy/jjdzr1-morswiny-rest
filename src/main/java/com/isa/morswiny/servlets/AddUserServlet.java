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
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet("/createAccount")
public class AddUserServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "createUser";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> map = new HashMap<>();


        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> model = new HashMap<>();
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int password = req.getParameter("password").hashCode();
        String passwordHashed = Integer.toString(password);

        if (isUserAlreadyRegistered(email)){
            model.put("accountExist", "AccountExist");
        } else if (register(createUser(name, surname, email, passwordHashed))){
            model.put("success", "success");
        } else {
            model.put("error", "error");
        }
        model.remove("logged");
        model.remove("admin");
        ServletService.sessionValidation(req, model);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }

    private boolean register (UserDto userDto) {
        if (isUserAlreadyRegistered(userDto.getEmail())){
            return false;
        } else {
            userService.save(userDto);
            return true;
        }
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

    private boolean isUserAlreadyRegistered(String email){
        return userService.getByEmail(email) != null;
    }

}
