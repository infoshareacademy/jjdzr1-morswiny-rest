package com.isa.morswiny.servlets;

import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.services.EventDbLoadService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loadEvents")
@MultipartConfig()
public class DataLoadServlet extends HttpServlet {
    private Map<String, Object> model = new HashMap<>();
    private static final String TEMPLATE_NAME = "loadData";
    private static final String SAVE_DIR = "uploadFiles";
    private static final String ARCHIVE_DIR = "archivedFiles";
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");


    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private EventDbLoadService eventDbLoadService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        model.put("user", "Admin");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appPath = req.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        PrintWriter writer = resp.getWriter();
        for (Part part : req.getParts()) {
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            String filePath = savePath + File.separator + fileName;
            Path pathToSource = Paths.get(filePath);
            if (!checkIfFileExists(filePath)) {
                part.write(filePath);
                eventDbLoadService.saveEventsFromJson(filePath);
                moveFileToArchive(pathToSource, fileName, req);
                STDOUT.info("successful load of events data!");
                resp.sendRedirect("/main-page");
            }
        }
    }

    private boolean checkIfFileExists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }

    private boolean moveFileToArchive(Path pathToSource, String nameOfFile, HttpServletRequest req) {
        String appPath = req.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + ARCHIVE_DIR;
        Path pathToTarget = Paths.get(savePath + File.separator + nameOfFile + LocalDateTime.now());
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        try {
            Files.move(pathToSource, pathToTarget, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
