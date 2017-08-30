package com.perepelitsya.service.interfaces;

import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;

import java.util.List;

/**
 * Created by Andriu on 8/14/2017.
 */
public interface StudentManager {

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(long id);

    Student getStudentById(long id);

    List<Student> getAllStudent();



}