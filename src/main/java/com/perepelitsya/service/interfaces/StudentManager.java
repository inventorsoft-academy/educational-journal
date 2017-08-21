package com.perepelitsya.service.interfaces;

import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;

import java.util.List;

/**
 * Created by Andriu on 8/14/2017.
 */
public interface StudentManager {

    void saveStudent();

    void updateStudent();

    void removeStudent();

    List<Student> getAllStudent();

}
