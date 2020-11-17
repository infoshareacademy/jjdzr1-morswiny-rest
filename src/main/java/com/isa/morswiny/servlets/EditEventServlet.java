package com.isa.morswiny.servlets;

import com.isa.morswiny.Dao.EventCRUDRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.parsers.DateTimeParser;
import com.isa.morswiny.model.*;
import com.isa.morswiny.services.ServletService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
@WebServlet("/edit-event")
public class EditEventServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "editEvent";
    private String idString = new String();
    private Organizer organizer = new Organizer();

    @Inject
    private EventCRUDRepositoryInterface eventCRUDRepositoryInterface;

    @Inject
    private DateTimeParser dateTimeParser;

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        idString = req.getParameter("id");

        Map<String, Object> map = new HashMap<>();

        ServletService.sessionValidation(req, map);

        Integer id = Integer.parseInt(idString);
        try {
            Event event = eventCRUDRepositoryInterface.getEventByID(id);
            map.put("event", event);
        } catch (NullPointerException e) {
            writer.println("Event not found");
        }

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(map, writer);
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }

    }



    protected void doGet2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        idString = req.getParameter("id");

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        String requested = req.getParameter("id");


        if (idString == null || idString.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Integer id = Integer.parseInt(idString);
        Event event = eventCRUDRepositoryInterface.getEventByID(id);

        event.setName(req.getParameter("eventName"));

        Place place = new Place();
        place.setName(req.getParameter("eventPlace"));
        event.setPlace(place);

        Organizer organizer = new Organizer();
        organizer.setDesignation(req.getParameter("organizer"));
        event.setOrganizer(organizer);

        EventURL url = new EventURL();
        url.setWww(req.getParameter("eventURL"));
        event.setUrls(url);

        event.setStartDate(req.getParameter("startDate"));
        event.setEndDate(req.getParameter("endDate"));

        //event.setStartDate(dateTimeParser.setDateFormat(event.getStartDate()));
        String check = new String ("check");
        //event.setEndDate(dateTimeParser.setDateFormat(event.getEndDate()));

        event.setDescLong(req.getParameter("description"));

        event.setAttachments(new Attachment[0]);

        Ticket ticket = new Ticket();
        ticket.setType(req.getParameter("ticket"));
        event.setTickets(ticket);

        event.setCategoryId(req.getParameter("categoryId"));
        event.setActive(Integer.valueOf(req.getParameter("active")));

        eventCRUDRepositoryInterface.updateEvent(event);
        Map<String, Object> map = new HashMap<>();
        map.put("event", event);

        System.out.println(map);

        resp.sendRedirect("/single-event?id=" +  event.getId());

//        Template template = templateProvider.createTemplate(
//                getServletContext(), TEMPLATE_NAME);
//        try {
//            template.process(map, writer);
//        } catch (TemplateException e) {
//            STDOUT.error("Error while processing template: ", e);
//        }
    }
}


