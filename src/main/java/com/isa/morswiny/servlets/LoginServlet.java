package com.isa.morswiny.servlets;


import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.freemarker.TemplateProvider;
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
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "login";
    private static final String ADMIN_EMAIL = "admin@morswiny.pl";

    @Inject
    UserService userService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
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

        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> map = new HashMap<>();
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        String email = req.getParameter("email");
        int password = req.getParameter("password").hashCode();
        String passwordHashed = Integer.toString(password);

        if (!ifUserExists(email)){
            map.put("NoUser", "NoUser");
        } else if (!verifyUser(email, passwordHashed)){
            map.put("wrongPassword", "WrongPassword");
        }
        else {
            UserDto user = logIn(email, passwordHashed);
            map.put("success", "success");
            if(user.getEmail().equals(ADMIN_EMAIL) ) {
                req.getSession().setAttribute("admin", user.getEmail());
            }
                req.getSession().setAttribute("logged", user.getEmail());
                resp.sendRedirect("/main-page");
        }

        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }

    }

    private boolean ifUserExists(String email){
        return userService.getByEmail(email) != null;
    }

    private UserDto logIn(String email, String password){
        return userService.getByEmail(email);
    }

    private boolean verifyUser(String email, String password){
        UserDto user = userService.getByEmail(email);
        return user.getPassword().equals(password);
    }

}
