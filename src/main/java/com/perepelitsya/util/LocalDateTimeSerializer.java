package com.perepelitsya.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Andriu on 8/24/2017.
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    DateTimeFormatter formatterDateForBirthday = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override

    public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        gen.writeString(date.format(formatterDateForBirthday));
    }
}
