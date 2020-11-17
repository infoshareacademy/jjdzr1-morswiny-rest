package com.isa.morswiny.servlets;

import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.mailService.Service;
import com.isa.morswiny.services.ServletService;
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

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "contact";
    private static final String TEMPLATE_RESULT_NAME = "contactResult";
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String ENCODING = "UTF-8";

    @Inject
    TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding(ENCODING);
        req.setCharacterEncoding(ENCODING);
        HashMap<String, Object> map = new HashMap<>();
        ServletService.sessionValidation(req, map);
        getTemplate(resp, map, TEMPLATE_NAME);


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding(ENCODING);
        req.setCharacterEncoding(ENCODING);
        HashMap<String, Object> map = new HashMap<>();

        if (sendEmail(req)){
            map.put("Success", "Success");

        } else {
            map.put("Error", "Error");
        }

        getTemplate(resp, map, TEMPLATE_RESULT_NAME);

    }

    protected void getTemplate(HttpServletResponse resp, HashMap map, String templateName) throws IOException {

        Template template = templateProvider.createTemplate(getServletContext(), templateName);
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }

    protected HashMap<String, String> getEmailData(HttpServletRequest req){
        HashMap<String, String> emailData = new HashMap<>();
        emailData.put("email", req.getParameter("mailAddress"));
        emailData.put("subject", req.getParameter("subject"));
        emailData.put("message", req.getParameter("message"));

        return emailData;
    }

    protected boolean sendEmail(HttpServletRequest req){
        HashMap<String, String> data = getEmailData(req);
        Service service = new Service();
        service.loadProperties();
        return service.send(data);
    }

}
