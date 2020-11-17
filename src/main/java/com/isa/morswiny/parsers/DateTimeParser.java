package com.isa.morswiny.parsers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@ApplicationScoped
public class DateTimeParser {

        public LocalDateTime setDateFormat(String date) {

            String format = "dd MMMM yyyy H:mm";
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
            LocalDateTime dateTime = LocalDateTime.parse(date, dtf);

            return dateTime;
        }
}
