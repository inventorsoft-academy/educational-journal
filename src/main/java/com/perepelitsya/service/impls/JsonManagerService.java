package com.perepelitsya.service.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;
import com.perepelitsya.service.interfaces.FileManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andriu on 8/20/2017.
 */
public class JsonManagerService implements FileManager {

    private final static Logger log = Logger.getLogger(FileManagerService.class);

    private final static String studentFile = "src\\main\\resources\\student.json";
    private final static String subjectFile = "src\\main\\resources\\subject.json";

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void writeToFileStudent(List<Student> studentList) throws IOException {
        for (Student student : studentList) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(studentFile), student);
            log.info("Json student created");
        }
    }

    @Override
    public void writeToFileSubject(List<Subject> subjectList) throws IOException {
        for (Subject subject : subjectList) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(subjectFile), subject);
            log.info("Json subject created");
        }
    }

    @Override
    public List<Student> readFromFileStudent() throws IOException {
        List<Student> studentList = new ArrayList<>();
        mapper.readValue(new File(studentFile), Student.class);
        return studentList;
    }

    @Override
    public List<Subject> readFromFileSubject() throws IOException {
        List<Subject> subjectList = new ArrayList<>();
        mapper.readValue(new File(subjectFile), Subject.class);
        return subjectList;
    }
}