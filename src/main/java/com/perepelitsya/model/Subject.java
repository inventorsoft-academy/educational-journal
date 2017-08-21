package com.perepelitsya.model;

import java.io.Serializable;

/**
 * Created by Andriu on 8/14/2017.
 */
public class Subject {
    private int idOfSubject;
    private String name;

    public Subject(int idOfSubject, String name) {
        this.idOfSubject = idOfSubject;
        this.name = name;
    }
    public Subject() {}

    public int getIdOfSubject() {
        return idOfSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + idOfSubject +
                ", name='" + name + '\'' +
                '}';
    }
}

