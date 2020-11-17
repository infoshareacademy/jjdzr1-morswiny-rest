package com.isa.morswiny.repository;


import com.google.gson.Gson;

import com.isa.morswiny.controller.EventRestController;
import com.isa.morswiny.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;

import com.google.gson.stream.JsonReader;

public class JsonEventDataLoad {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public Event[] getJsonEventData(String pathToJson) {
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        try {
           // File file = new File(getClass().getClassLoader().getResource("events.json").getFile());
            File file = new File(pathToJson);
            jsonReader = new JsonReader(new FileReader(file));
        } catch (Exception e) {
            STDOUT.error("Plik nie moze byc znaleziony lub nie jest w formacie JSON. Upewnij sie, ze podales wlasciwe dane.");
            return new Event[0];
        }
        return gson.fromJson(jsonReader, Event[].class);
    }


//    public Event[] loadDataFromJson ()  {
//
//        EventRestController eventRestController = new EventRestController();
//        return eventRestController.getJsonEvents();
//
//    }



}
