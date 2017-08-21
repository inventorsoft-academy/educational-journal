package com.perepelitsya.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andriu on 8/14/2017.
 */
public class Student{

    private int id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDay;
    private int group;
    private LocalDateTime mark;
    private List<Subject> subjects;

    public Student(int id, String firstName, String lastName, LocalDateTime birthDay, int group, LocalDateTime mark, List<Subject> subjects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.group = group;
        this.mark = mark;
        this.subjects = subjects;
    }



    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDateTime getMark() {
        return mark;
    }

    public void setMark(LocalDateTime mark) {
        this.mark = mark;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", group=" + group +
                ", mark=" + mark +
                ", subjects=" + subjects +
                '}';
    }


}