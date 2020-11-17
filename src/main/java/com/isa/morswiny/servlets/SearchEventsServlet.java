package com.isa.morswiny.servlets;

import com.isa.morswiny.Dao.FavouritesDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.services.EventService;
import com.isa.morswiny.services.FavouritesService;
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
import java.util.*;

@WebServlet("/search-events")
public class SearchEventsServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger(SearchEventsServlet.class);
    private static final String TEMPLATE_NAME = "searchEvents";
    private Map<String, Object> model = new HashMap<>();

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Inject
    private FavouritesService favouritesService;

    @Inject
    private FavouritesDao favouritesDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Integer limit = 20;
        String page = req.getParameter("page");
        Integer count = 5; //ilosc wszystkich eventow w bazie podxzielonych przez limit

        if(page==null){
            page = "0";
        }

        Integer pageInt = Integer.parseInt(page);

        model.remove("logged");
        model.remove("admin");
        ServletService.sessionValidation(req, model);

        if(checkIfUserLogged(req)){
            Integer userId = returnUserIdFromSession(req);
            if(req.getParameter("addEvent")!=null){
                EventDto eventDto = getEventDtoFromUserRequest(req);
                addEventToFavourites(userId,eventDto);
            }
        }

        String userQuery = req.getParameter("search");

        initModel(model, userQuery,limit, pageInt, count);
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: " + template.getName(), e);
        }
    }

    private Integer returnUserIdFromSession(HttpServletRequest req) {
        String email = (String) req.getSession().getAttribute("logged");
        Integer userId = getUserId(email);
        return userId;
    }

    private EventDto getEventDtoFromUserRequest(HttpServletRequest req) {
        Integer eventId = Integer.parseInt(req.getParameter("addEvent"));
        Event event = favouritesDao.find(eventId);
        return favouritesService.provideEventDto(event);
    }

    private boolean checkIfUserLogged(HttpServletRequest req) {
        return (req.getSession().getAttribute("logged") != null);
    }


    private void initModel(Map model, String query,Integer limit, Integer page, Integer count) {
        model.put("userQuery", query);
        model.put("listOfQueriedEvents", setListOfQueriedEvents(query));
        model.put("limit",limit);
        model.put("page",page);
        model.put("count",count);
    }

    private List<EventDto> setListOfQueriedEvents(String userQuery) {
        return eventService.findByFreeText(userQuery);
    }

    private int getUserId(String email){
        UserDto user = favouritesService.getUserByEmail(email);
        return user.getId();
    }



    private boolean addEventToFavourites(Integer userId,EventDto eventDto){
        boolean isAlreadyInFavourites = isEventInFavouritesAlready(userId,eventDto);
        if(!isAlreadyInFavourites){
            favouritesService.addToFavourites(userId,eventDto);
            return true;
        }else{
            favouritesService.removeFromFavourite(userId,eventDto);
            return false;
        }
    }

    private boolean isEventInFavouritesAlready(Integer userId, EventDto eventDto){
        Event event = favouritesService.provideEvent(eventDto);
        Set<Event> favourites = setListOfFavouritesEventsForUser(userId);
        boolean check = favourites.contains(event);
        return favourites.contains(event);
    }

    private Set<Event> setListOfFavouritesEventsForUser(Integer userId){
        return favouritesService.getAllFavouritesForUser(userId);
    }



}
