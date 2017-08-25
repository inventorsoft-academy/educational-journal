package com.perepelitsya.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.perepelitsya.custom.CustomValidator;
import lombok.*;

import java.util.HashMap;

/**
 * Created by Andriu on 8/14/2017.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.STRING)
public class Subject implements CustomValidator {

    private long idOfSubject;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public HashMap<String, String> validate() {
        HashMap<String, String> valid = new HashMap<>();
        if (name == null || name.length() < 4 || name.length() > 20) {
            valid.put(name, "Incorrect value of name subject\nName cannot be null. Name must be more than 4 and less than 20");
        }
        return valid;
    }
}