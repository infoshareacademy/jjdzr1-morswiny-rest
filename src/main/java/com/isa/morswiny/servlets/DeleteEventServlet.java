package com.isa.morswiny.servlets;

import com.isa.morswiny.Dao.EventCRUDRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
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
@WebServlet("/delete-event")
public class DeleteEventServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "deleteEvent";

    @Inject
    private EventCRUDRepositoryInterface eventCRUDRepositoryInterface;

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

        Integer id = Integer.parseInt(req.getParameter("id"));
        eventCRUDRepositoryInterface.deleteEvent(id);

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        ServletService.sessionValidation(req, map);

        System.out.println(eventCRUDRepositoryInterface.getAllEventsList());

        Template template = templateProvider.createTemplate(
                getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, writer);
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }
}


