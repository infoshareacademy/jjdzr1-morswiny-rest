package com.isa.morswiny.servlets;

import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.services.ServletService;
import com.isa.morswiny.services.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/DeleteAccount")
public class DeleteAccountServlet extends HttpServlet {

    @Inject
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> map = new HashMap<>();
        ServletService.sessionValidation(request, map);

        userService.delete(userService.getByEmail((String) request.getSession().getAttribute("logged")));
        response.sendRedirect("/logout");
    }

}
