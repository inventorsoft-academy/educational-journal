package com.perepelitsya.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Andriu on 8/24/2017.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

//    DateTimeFormatter formatterDateForBirthday = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    DateTimeFormatter formatterDateForMark = DateTimeFormatter.ofPattern("MM-dd HH:mm");

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        return LocalDateTime.parse(parser.readValueAs(String.class));
//
//        return LocalDate.parse(parser.readValueAs(String.class));


    }
}


