package com.isa.morswiny.repository;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.services.EventDbLoadService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RequestScoped
public class EventRepository {

    @Inject
    private EventDao eventDao;
    @Inject
    private EventDbLoadService eventDbLoadService;


    private static List<Event> eventRepository = new ArrayList<>();

    //TODO - dodawanie nowych eventow
    public static List<Event> getEventRepository() throws IOException {
       //TODO: usun te metode? albo parametryzacje pathToJson
        String pathToJson="";
        if(eventRepository.size() == 0){
            fillEventRepositoryWithJsonEvents(pathToJson);
        }
        return eventRepository;
    }

    public static void fillEventRepositoryWithJsonEvents(String pathToJson) throws IOException {
        eventRepository.addAll(new JsonEventDataManagement().createListOfAllEvents(pathToJson));
    }

    public List<Event> readJsonToList(String pathToJson){
        JsonEventDataManagement jsonEventDataManagement = new JsonEventDataManagement();
        List<Event> events = new ArrayList<>();
        try {
            events = jsonEventDataManagement.createListOfAllEvents(pathToJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }



}
