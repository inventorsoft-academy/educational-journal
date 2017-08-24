package com.perepelitsya.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Andriu on 8/14/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Student implements CustomValidator {

    private long id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDay;
    private long group;
    private LocalDateTime mark;
    private List<Subject> subjects;


    public void setGroup(int group) {
        this.group = group;
    }

    public void setMark(LocalDateTime mark) {
        this.mark = mark;
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

    @Override
    public ArrayList<String> validate() {
        ArrayList<String> valid = new ArrayList<>();
        if (firstName == null || firstName.length() < 4 || firstName.length() > 24) {
            valid.add("firstName entered incorrectly");
        }
        if (lastName == null || lastName.length() < 4 || lastName.length() > 24) {
            valid.add("lastName entered incorrectly");
        }
        if (birthDay == null || birthDay.getYear() < 1930 || birthDay.getYear() > 2017) {
            valid.add("birthDay entered incorrectly");
        }
        if (group == 0 || group <= 0 || group >= 11) {
            valid.add("group entered incorrectly");
        }
        if (mark == null || mark.getYear() < 2017 || mark.getYear() > 2017) {
            valid.add("mark entered incorrectly");
        }
        if (subjects == null || subjects.size() < 1 || subjects.size() > 12) {
            valid.add("subjects entered incorrectly");
        }

        return valid;
    }
}