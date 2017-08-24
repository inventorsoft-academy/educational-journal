package com.perepelitsya.service.interfaces;

import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Andriu on 8/14/2017.
 */
public interface FileManager {

    void writeToFileStudent(List<Student> studentList) throws IOException;

    void writeToFileSubject(List<Subject> subjectList) throws IOException;

    List<Student>  readFromFileStudent() throws IOException, ParseException;

    List<Subject>  readFromFileSubject() throws IOException, ParseException;
}
