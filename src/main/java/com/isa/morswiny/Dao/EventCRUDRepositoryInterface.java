package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EventCRUDRepositoryInterface {

    List<Event> getAllEventsList();
    Event getEventByID(Integer id);
    boolean isEventExisting(Event event);
    Integer getNextID();
    boolean createEvent(Event event);
    boolean deleteEvent(Integer eventId);
    boolean updateEvent(Event event);
}
