package com.isa.morswiny.comparators;

import com.isa.morswiny.model.Event;
import java.util.Comparator;

public class DateComparator implements Comparator<Event> {

    @Override
    public int compare(Event event, Event event1) {
        return event.getStartDate().compareTo(event1.getStartDate());
    }
}
