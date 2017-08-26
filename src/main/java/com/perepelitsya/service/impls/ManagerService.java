package com.perepelitsya.service.impls;

import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;
import com.perepelitsya.service.interfaces.StudentManager;
import com.perepelitsya.service.interfaces.SubjectManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class ManagerService implements StudentManager, SubjectManager {

    private final static Logger log = Logger.getLogger(ManagerService.class);

    private List<Student> studentList = new ArrayList<>();
    private List<Subject> subjectList = new ArrayList<>();


    public void saveStudent(Student student) {
        if (student.validate().isEmpty()) {
            studentList.add(student);
        } else {
            log.info("you cannot add new student.\nPS. Validator");
            for (Map.Entry<String, String> map : student.validate().entrySet()) {
                System.out.println(map.getValue() + ". False: " + map.getKey());
            }

        }

    }

    public void saveSubject(Subject subject) {
        if (subject.validate().isEmpty()) {
            subjectList.add(subject);
        } else {
            log.info("you cannot add new subject.\nPS. Validator");
            for (Map.Entry<String, String> map : subject.validate().entrySet()) {
                System.out.println(map.getValue() + ". False: " + map.getKey());
            }
        }
    }

    public Student getStudentById(long id) {
        Student myStudent = new Student();
        for (Student student : studentList) {
            if (id == student.getId()) {
                myStudent = student;
            } else {
                log.error("Student with id " + id + " dont exist!");
            }
        }
        return myStudent;
    }

    public Subject getSubjectById(long id) {
        Object a = null;
        for (Subject subject : subjectList) {
            if (subject.getIdOfSubject() == id) {
                a = subject;
            } else {
                log.error("Subject with id " + id + " dont exist!");
            }
        }
        return (Subject) a;
    }

    public void deleteStudentById(long id) {
        studentList.removeIf(student -> student.getId() == id);
    }

    public void deleteSubjectById(long id) {
        subjectList.removeIf(subject -> subject.getIdOfSubject() == id);
    }

    public List<Student> getAllStudent() {
        log.info("we see all info about our student");
        return studentList;
    }

    public List<Subject> getAllSubject() {
        log.info("we see all info about our subject");
        return subjectList;
    }
}