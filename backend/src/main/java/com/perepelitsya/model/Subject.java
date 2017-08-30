package com.perepelitsya.model;

import com.perepelitsya.util.CustomValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

/**
 * Created by Andriu on 8/14/2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements CustomValidator {

    private long idOfSubject;

    private String name;

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