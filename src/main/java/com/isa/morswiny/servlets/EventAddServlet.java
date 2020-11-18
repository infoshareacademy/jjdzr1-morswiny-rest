package com.isa.morswiny.servlets;

import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.model.Place;
import com.isa.morswiny.parsers.DateTimeParser;
import com.isa.morswiny.services.EventService;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@WebServlet("/event-add")
public class EventAddServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "addEvent";


    @Inject
    EventService eventService;

    @Inject
    DateTimeParser dateTimeParser;

    @Inject
    TemplateProvider templateProvider;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> map = new HashMap<>();
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        String eventName = req.getParameter("eventName");
        String placeName = req.getParameter("placeName");
        String placeSubname = req.getParameter("placeSubname");
        String organizer = req.getParameter("organizer");
        String urlTickets = req.getParameter("urlTickets");
        String


    }

    private Place


}
