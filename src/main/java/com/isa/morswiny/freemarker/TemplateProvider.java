package com.isa.morswiny.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.Serializable;

@ApplicationScoped
public class TemplateProvider implements Serializable {

    public static final String TEMPLATES_DIRECTORY_PATH = "WEB-INF/fm-templates";
    private static final String TEMPLATE_EXT = ".ftlh";


    public Template createTemplate(ServletContext servletContext, String templateName) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);

        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATES_DIRECTORY_PATH);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setNumberFormat("0.######");


        return configuration.getTemplate(templateName + TEMPLATE_EXT);

    }
}
