package com.perepelitsya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Created by Andriu on 8/14/2017.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements CustomValidator {

    private int idOfSubject;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject[" + " name= " + name + '\'' + ']';
    }

    @Override
    public ArrayList<String> validate() {
        ArrayList<String> valid = new ArrayList<>();
        if(name==null || name.length()<4 || name.length() > 20){
            valid.add("Subject entered incorrectly");
        }
        return valid;
    }
}