package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.repository.EventRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.*;

@RequestScoped
public class EventDbLoadService {

    @Inject
    private EventDao eventDao;

    @Inject
    private EventRepository eventRepository;


    public void saveEventsFromJson(String pathToJson)  {
        List<Event> events = eventRepository.readJsonToList(pathToJson);
        events.stream()
                .filter(e -> !eventDao.findByJsonId(e.getId()))
                .forEach(e -> eventDao.save(e));
    }

}
