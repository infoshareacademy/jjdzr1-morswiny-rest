package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;
import com.isa.morswiny.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.*;

@Stateless
@Slf4j
public class EventCRUDRepository implements EventCRUDRepositoryInterface , Serializable {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");



    public List<Event> getAllEventsList()  {
        try{
        return EventRepository.getEventRepository();}
        catch (Exception e){
            return new ArrayList<>();
        }


    }

    @Override
    public Event getEventByID(Integer id)  {
        List<Event> list = getAllEventsList();
        for (Event event : list){
            if (id.equals(event.getId())){ //do poprawy - byl getter
                return event;
            }
        }
        return null;
    }

    @Override
    public boolean isEventExisting(Event event)  {
        if (Objects.nonNull(event)){
        return getAllEventsList().contains(event);
        }
        return false;
    }

    @Override
    public Integer getNextID()  {
        Event event = Collections.max(getAllEventsList(), Comparator.comparing(Event::getId));
        return event.getId() + 1;
    }

    @Override
    public boolean createEvent(Event event)  {
        if (!isEventExisting(event)) {
            getAllEventsList().add(event);
            STDOUT.info("New event has been created\n");
            return true;
        } else {
            STDOUT.info("Event already existing or not defined");
        }
        return false;
    }
    @Override
    public boolean deleteEvent(Integer eventId)  {
        ListIterator<Event> i = getAllEventsList().listIterator();
        while(i.hasNext()){
            Event event = i.next();
            if (event.getId().equals(eventId)){
                i.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateEvent(Event event) {
        if (getAllEventsList().contains(event)) {
            deleteEvent(event.getId());
            createEvent(event);
        }
        return false;
    }
}
