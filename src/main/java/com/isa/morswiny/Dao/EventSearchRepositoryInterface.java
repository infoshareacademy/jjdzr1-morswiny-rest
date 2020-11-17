package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;

import java.util.List;

public interface EventSearchRepositoryInterface {

    //wyszukiwanie String
    List<Event> searchByString(String name);


    //wyszukiwanie po dacie

    //wyszukiwanie po organizatorze
    List <Event> searchByOrganizer (String organizer);

    //wyszukiwanie po miejscu
    List<Event> searchByPlace (String place);

    //wyszukiwanie aktywnych/nieaktywnych eventow
    List<Event> searchActive (Integer active);

    //filtrowanie eventow po nazwie == sortowanie
    List<Event> searchByName(String name);
}
