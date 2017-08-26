package com.perepelitsya.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.perepelitsya.util.CustomValidator;
import com.perepelitsya.util.LocalDateTimeDeserializer;
import com.perepelitsya.util.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Andriu on 8/14/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student implements CustomValidator {


    private long id;
    private String firstName;
    private String lastName;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birthDay;
    private long group;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "MM-dd HH:mm")
    private LocalDateTime mark;
    private List<Subject> subjects;


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
//        DateTimeFormatter formatterDateForBirthday = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        DateTimeFormatter formatterDateForMark = DateTimeFormatter.ofPattern("MM-dd HH:mm");

        if (firstName == null || firstName.length() < 4 || firstName.length() > 24) {
            valid.put(firstName, "the field of firstName is incorrect\n FirstName cannot be null. FirstName must be more than 4 and less than 24");
        }
        if (lastName == null || lastName.length() < 4 || lastName.length() > 24) {
            valid.put(lastName, "the field of lastName is incorrect\n LastName cannot be null. LastName must be more than 4 and less than 24");
        }

        if (birthDay == null || birthDay.getYear() < 1930 || birthDay.getYear() > 2017) {
            valid.put(String.valueOf(birthDay), "the field of birthDay is incorrect\n BirthDay cannot be null. BirthDay must be more than 1930 and less than 2017");
        }
        if (group == 0 || group <= 0 || group > 12) {
            valid.put(String.valueOf(group), "the field of group is incorrect\nGroup cannot be null. Group must be more than 0 and less than 12");
        }
        if (mark == null || mark.getYear() < 2017 || mark.getYear() > 2017) {
            valid.put(String.valueOf(mark), "the field of mark is incorrect\nMark cannot be null. Mark must be more than 2017 and less than 2017");
        }
        if (subjects == null || subjects.size() < 1 || subjects.size() > 12) {
            valid.put(String.valueOf(subjects), "the field of subjects is incorrect\nSubjects cannot be null");
        }
        return valid;
    }

}