package com.isa.morswiny.repository;

import com.isa.morswiny.comparators.DateComparator;
import com.isa.morswiny.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JsonEventDataManagement {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");


    public List<Event> createListOfAllEvents(String pathToJson) throws IOException {
        try {
            //TODO do podmiany getJsonEventData() na dzialajace loadDataFromJson()
            Event[] gsonEvents = new JsonEventDataLoad().getJsonEventData(pathToJson);
            List<Event> eventsList = new ArrayList<>(Arrays.asList(gsonEvents));
            trimDateStrings(eventsList);
            setLocalDateTimeInList(eventsList);
            formatStartEndDate(eventsList);
            trimDescription(eventsList);
            eventsList.sort(new DateComparator());
            return eventsList;
        } catch (Exception e) {
            return new ArrayList<Event>();
        }
    }

    //method trims given StartDate and EndDate Strings form JSON file so they can be parsed to LocalDateTime
    private void trimDateStrings(List<Event> list){
        for (Event event : list){
            if (event.getStartDate() != null){
                event.setStartDate(event.getStartDate().substring(0, 19));
            }
            if (event.getEndDate() != null){
                event.setEndDate(event.getEndDate().substring(0, 19));
            }
        }
    }

    //method sets LocalDateTimes to events from JSON file
    private void setLocalDateTimeInList (List<Event> list) {
        for (Event event : list) {
            if (event.getStartDate() != null) {
                LocalDateTime localDateTime = LocalDateTime.parse(event.getStartDate());
                event.setStartDateLDT(localDateTime);
            }
            if (event.getEndDate() != null) {
                LocalDateTime localDateTime = LocalDateTime.parse(event.getEndDate());
                event.setEndDateLDT(localDateTime);
            }
        }
    }

    //method formats StartDate and EndDate Strings to format form property file
    private void formatStartEndDate(List<Event> list){
        Properties prop = readPropertiesFile();
        DateTimeFormatter dtf;
            try {
                dtf = DateTimeFormatter.ofPattern(prop.getProperty("date.format"));
            } catch (NullPointerException e){
                STDOUT.error("Property file not found!");
                dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy H:mm");
            }
        for (Event event : list){
            if (event.getStartDate() != null){
                event.setStartDate(event.getStartDateLDT().format(dtf));
            }
            if (event.getEndDate() != null){
                event.setEndDate(event.getEndDateLDT().format(dtf));
            }
        }
    }

    private Properties readPropertiesFile() {

        FileInputStream property = null;
        Properties prop = null;
        try {
            File file = new File(getClass().getClassLoader().getResource("config.properties").getFile());
            property = new FileInputStream(file);
            prop = new Properties();
            prop.load(property);
        } catch (IOException e) {
            STDOUT.info("Cannot find property file");
        } finally {
            assert property != null;
            try {
                property.close();
            } catch (IOException e) {
                STDOUT.info("Cannot find property file");
            }
        }
        return prop;
    }

    //method trims descriptions from JSON file
    private void trimDescription(List<Event> list){
        for (Event event : list){
            if (event.getDescLong() != null){
                event.setDescLong(event.getDescLong().replaceAll("\\<.*?>",""));
            }
        }
    }

}
