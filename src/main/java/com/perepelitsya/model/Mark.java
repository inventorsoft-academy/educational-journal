package com.perepelitsya.model;

import com.perepelitsya.util.CustomValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

/**
 * Created by Andriu on 8/28/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mark implements CustomValidator {

    private Subject subject;

    private int mark;


    @Override
    public String toString() {
        return "Mark{" +
                "subject=" + subject +
                ", mark=" + mark +
                '}';
    }

    @Override
    public HashMap<String, String> validate() {
        HashMap<String, String> valid = new HashMap<>();
        if (mark == 0 || mark <= 2 || mark > 12) {
            valid.put(String.valueOf(mark), "the field of group is incorrect\nMark cannot be null. Mark must be more than 1 and less than 13");
        }
        return valid;
    }
}
