package com.perepelitsya.service.impls;

import com.perepelitsya.model.Mark;
import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;
import com.perepelitsya.service.interfaces.MarkManager;
import com.perepelitsya.service.interfaces.StudentManager;
import com.perepelitsya.service.interfaces.SubjectManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ManagerService implements StudentManager, SubjectManager, MarkManager {

    private final static Logger log = Logger.getLogger(ManagerService.class);

    private List<Student> studentList = new ArrayList<>();
    private List<Subject> subjectList = new ArrayList<>();
//    private List<Mark> markList = new ArrayList<>();

    //    @Override
//    public void addMark(Student student, int mark) {
//        for (Student addMarkSt : studentList) {
//            if (student.equals(addMarkSt)) {
//                for (Subject addSub : subjectList) {
//                    Mark markToList = new Mark();
//                    markToList.setSubject(addSub);
//                    markToList.setMark(mark);
//                    markList.add(markToList);
//                    student.setMarks(markList);}}}}

    @Override
    public void addMarksToStudent(long id, Mark mark) {
        ArrayList<Mark> markArrayList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getId() == id) {
                if (mark.validate().isEmpty()) {
                    for (Subject subject : subjectList) {
                        mark.setSubject(subject);
                        markArrayList.add(mark);
                        student.setMarks(markArrayList);
                    }
                } else {
                    log.info("you cannot add new mark.\nPS. Validator");
                    for (Map.Entry<String, String> map : mark.validate().entrySet()) {
                        System.out.println(map.getValue() + ". False: " + map.getKey());
                    }
                }
            } else {
                System.out.println("Student dont exist");
            }
        }
    }

//    public void addMarksToStudent(long id, Mark mark) {
//        ArrayList<Mark> markArrayList = new ArrayList<>();
//        for (Student student : studentList) {
//            if (student.getId() == id) {
//                saveMark(mark);
//                student.setMarks(markList);
////                markArrayList.add(saveMark(mark));
////                student.setMarks(markArrayList);
//            }
//        }
//    }

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