package com.perepelitsya.service.impls;

import com.perepelitsya.model.Mark;
import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;
import com.perepelitsya.service.interfaces.MarkManager;
import com.perepelitsya.service.interfaces.StudentManager;
import com.perepelitsya.service.interfaces.SubjectManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ManagerService implements StudentManager, SubjectManager, MarkManager {

    private final static Logger log = Logger.getLogger(ManagerService.class);

    private List<Student> studentList = new ArrayList<>();
    private List<Subject> subjectList = new ArrayList<>();


    public void addMarksToStudent(long id, long subject_id, int mark) {
        try {
            Mark studentMark = new Mark();
            for (Subject subject : subjectList) {
                if (subject.getIdOfSubject() == subject_id) {
                    studentMark.setSubject(subject);
                    studentMark.setMark(mark);
                    log.info("add mark into method");
                }
            }
            if (studentMark.validate().isEmpty()) {
                ArrayList<Mark> markArrayList = new ArrayList<>();
                for (Student student : studentList) {
                    if (student.getId() == id) {
                        markArrayList.add(studentMark);
                        log.info("try to add mark to list to st");
                        student.setMarks(markArrayList);
                    } else {
                        System.out.println("Student dont exist");
                    }
                }
            } else {
                log.info("you cannot add new mark.\nPS. Validator");
                for (Map.Entry<String, String> map : studentMark.validate().entrySet()) {
                    System.out.println(map.getValue() + ". False: " + map.getKey());
                }
            }
        } catch (Exception e) {
            log.error("Failed");
        }
    }


    public void saveStudent(Student student) {
        if (student.validate().isEmpty()) {
            student.setId(studentList.size() + 1);
            studentList.add(student);
        } else {
            log.info("you cannot add new student.\nPS. Validator");
            for (Map.Entry<String, String> map : student.validate().entrySet()) {
                System.out.println(map.getValue() + ". False: " + map.getKey());
            }
        }
    }

    public void updateStudent(Student student) {
        for (Student studentUpdate : studentList) {
            if (studentUpdate.getId() == student.getId()) {
                student.setId(studentUpdate.getId());
            }
        }
    }

    public void saveSubject(Subject subject) {
        if (subject.validate().isEmpty()) {
            subject.setIdOfSubject(subjectList.size() + 1);
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

//    List<Integer> subjectIds = Arrays.stream(line[6].split(" , "))
//            .map(Integer::valueOf)
//            .collect(Collectors.toList());
//
//    List<Subject> subjects = getAllSubject();
//
//    List<Subject> studentSubjects = subjects.stream()
//            .filter(sub -> subjectIds.contains(sub.getIdOfSubject()))
//            .collect(Collectors.toList());
}