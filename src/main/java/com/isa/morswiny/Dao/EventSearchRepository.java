package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SessionScoped
public class EventSearchRepository implements EventSearchRepositoryInterface, Serializable {

    @Inject
    private EventCRUDRepositoryInterface eventCRUDRepositoryInterface;


    @Override
    public List<Event> searchByString(String userInput) {
        List<Event> list = new ArrayList<>();
        String eventSpecification;
        for (Event event : eventCRUDRepositoryInterface.getAllEventsList()) {
            eventSpecification = event.returnEventParams();
            if (eventSpecification.toLowerCase()
                    .contains
                            (userInput.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByOrganizer(String organizer) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventCRUDRepositoryInterface.getAllEventsList()) {
            if (event.getOrganizer().getDesignation().toLowerCase()
                    .contains
                            (organizer.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByPlace(String place) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventCRUDRepositoryInterface.getAllEventsList()) {
           /* String nameAndSubname = event.getPlace().getName() + event.getPlace().getSubname();
            if (nameAndSubname.toLowerCase()
                    .contains(
                            place.toLowerCase())) {
                list.add(event);
            }*/
        }
        return list;
    }

    @Override
    // 1 if active, 0 if inactive
    public List<Event> searchActive(Integer active) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventCRUDRepositoryInterface.getAllEventsList()) {
            if (event.getActive().equals(active)) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByName(String name) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventCRUDRepositoryInterface.getAllEventsList()) {
            if (event.getName().toLowerCase()
                    .contains(
                            name.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }



    // method to search for event dates
//    public List<Event> searchByExactDate(String date) {
//        LocalDate queryDate = stringToLocalDate(date);
//
//        List<Event> list = new ArrayList<>();
//        for (Event event : eventSet) {
//            LocalDate eventStart = stringToLocalDate(event.getStartDate());
//            LocalDate eventEnd = stringToLocalDate(event.getEndDate());
//            if (eventStart.isBefore(queryDate) && eventEnd.isAfter(queryDate)) {
//                list.add(event);
//            }
//        }
//        return list;
//    }
//
//    // method to search for event dates
//    public List<Event> searchByMonth (String date) {
//        LocalDate queryDate = stringToLocalDate(date);
//        int queryMonth = queryDate.getMonth().getValue();
//        List<Event> list = new ArrayList<>();
//        for (Event event : eventSet) {
//            LocalDate eventStart = stringToLocalDate(event.getStartDate());
//            LocalDate eventEnd = stringToLocalDate(event.getEndDate());
//            int startMonth = eventStart.getMonth().getValue();
//            int endMonth = eventEnd.getMonth().getValue();
//            if (startMonth < queryMonth
//                    &&
//                    endMonth >= queryMonth) {
//                list.add(event);
//            }
//        }
//        return list;
//    }

}