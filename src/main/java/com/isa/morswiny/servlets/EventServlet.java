package com.isa.morswiny.servlets;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.services.ServletService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
@WebServlet("/single-event")
public class EventServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "singleEvent";

    @Inject
    private EventDao eventDao;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;

        }
        Map<String, Object> map = new HashMap<>();

        ServletService.sessionValidation(req, map);

        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            Optional<Event> event = eventDao.find(id);
            map.put("event", event.get());
            if (event.get().getAttachments().length > 0){
                map.put("picture", event.get().getAttachments()[0].getFileName());
            }
            if (event.get().getUrls().getWww() != null){
                map.put("tickets", event.get().getUrls().getWww());
            }
        } catch (NullPointerException e) {
            writer.println("Event not found");
        }

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }
}
