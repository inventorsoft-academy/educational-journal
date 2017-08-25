package com.perepelitsya.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.perepelitsya.custom.CustomValidator;
import com.perepelitsya.util.LocalDateTimeDeserializer;
import com.perepelitsya.util.LocalDateTimeSerializer;
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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime birthDay;
    private long group;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
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
    public HashMap<String, String> validate() {
        HashMap<String, String> valid = new HashMap<>();
        if (firstName == null || firstName.length() < 4 || firstName.length() > 24) {
            valid.put(firstName, "the field of firstName is incorrect");
        }
        if (lastName == null || lastName.length() < 4 || lastName.length() > 24) {
            valid.put(lastName, "the field of lastName is incorrect");
        }
        if (birthDay == null || birthDay.getYear() < 1930 || birthDay.getYear() > 2017) {
            valid.put(String.valueOf(birthDay), "the field of birthDay is incorrect");
        }
        if (group == 0 || group <= 0 || group >= 11) {
            valid.put(String.valueOf(group), "the field of group is incorrect");
        }
        if (mark == null || mark.getYear() < 2017 || mark.getYear() > 2017) {
            valid.put(String.valueOf(mark), "the field of mark is incorrect");
        }
        if (subjects == null || subjects.size() < 1 || subjects.size() > 12) {
            valid.put(String.valueOf(subjects), "the field of subjects is incorrect");
        }
        return valid;
    }

}