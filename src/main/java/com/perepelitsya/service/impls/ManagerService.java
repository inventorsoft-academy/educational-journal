package com.perepelitsya.service.impls;

import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;
import com.perepelitsya.service.interfaces.StudentManager;
import com.perepelitsya.service.interfaces.SubjectManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by Andriu on 8/14/2017.
 */
@Component
public class ManagerService implements StudentManager, SubjectManager {

    private final static Logger log = Logger.getLogger(ManagerService.class);

    DateTimeFormatter formatterDateForBirthday = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter formatterDateForMark = DateTimeFormatter.ofPattern("MM-dd HH:mm");

    private List<Student> studentList = new ArrayList<>();
    private List<Subject> subjectList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    public void deleteStudentById(long id) {
        studentList.remove(id);
    }

    public void saveStudent() {
        int sizeOfStudentsArray = studentList.size();
        System.out.println("Please enter firstName");
        String firstName = sc.next();
        System.out.println("Please enter lastName");
        String lastName = sc.next();
        System.out.println("Please enter group");
        int group = Integer.parseInt(sc.next());
        System.out.println("Please enter birthDay");
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime.format(formatterDateForBirthday);
        System.out.println("Please enter mark");
        LocalDateTime mark = LocalDateTime.now();
        mark.format(formatterDateForMark);
        System.out.println("Please enter subject");
        List<Subject> subjectForStudent = new ArrayList<>();
        log.info("Try to add subject for student");
        //this code will be recreatted to separate method
        System.out.println("Please enter yes if you want to learn that subject, and enter no in another case");
        for (Subject subject : subjectList) {
            System.out.println("Lets add some subject");
            System.out.print(subject + "   ");
            String ansver = sc.next();
            if ("Yes".equalsIgnoreCase(ansver)) {
                subjectForStudent.add(subject);
                log.info("we add subject =  " + subject.getName());
            } else if ("No".equalsIgnoreCase(ansver)) {
                log.info("we cannot add  subject =  " + subject.getName());

            }
        }
        try {
            Student student = new Student(getAllStudent().size() + 1, firstName, lastName, dateTime, group, mark, subjectForStudent);
            if (student.validate().isEmpty()) {
                studentList.add(student);
                log.info("Student created!");
            } else {
                for (Map.Entry<String, String> map : student.validate().entrySet()) {
                    System.out.println(map.getValue() + ". False: " + map.getKey());
                }
                System.out.println("You input incorrect data. Please try again");
            }
        } catch (Exception ex) {
            log.error("Student cannot create ", ex);
        }
    }

    public void updateStudent() {
        long oldGroup;
        LocalDateTime oldDate;
        List<Subject> oldSubjects = null;

        log.info("Lets find student who will be update");
        System.out.println("Enter name of student who will be update");
        String lastNameOfStuent = sc.next();
        try {
            for (Student student : studentList) {
                if (student.getLastName().equals(lastNameOfStuent)) {
                    log.info("We find our student. Let get start to update him");

                    System.out.println("Please enter another group");
                    oldGroup = student.getGroup();
                    int group = Integer.parseInt(sc.next());
                    student.setGroup(group);
                    log.info("we change group " + oldGroup + " to = " + group);


                    System.out.println("Please enter mark");
                    oldDate = student.getMark();
                    LocalDateTime time = LocalDateTime.now();
                    time.format(formatterDateForMark);
                    student.setMark(time);
                    log.info("we change mark " + oldDate + " to = " + time);

                    System.out.println("Please enter another subjects");
                    oldSubjects = student.getSubjects();


                    try {
                        if (student.getSubjects() != null) {
                            //this code will be recreatted to separate method
                            System.out.println("Please enter YES if you want to remove that subject, and enter NO in another case");
                            for (Subject subject : student.getSubjects()) {
                                System.out.print(subject + "   ");
                                String ansver = sc.next();
                                if ("Yes".equalsIgnoreCase(ansver)) {
                                    student.getSubjects().remove(subject);
                                    log.info("we delete subject =  " + subject.getName());
                                } else if ("No".equalsIgnoreCase(ansver)) {
                                    log.info("we cannot delete this  subject =  " + subject.getName());
                                }
                            }
                        }
                    } catch (Exception ex) {
                        log.error("Student havent subjects");
                    }

                    //this code will be recreatted to separate method
                    System.out.println("Please enter yes if you want to learn that subject, and enter no in another case");
                    for (Subject subject : subjectList) {
                        System.out.println("Lets add some subject");
                        System.out.print(subject + "   ");
                        String ansverAdd = sc.next();
                        if ("Yes".equalsIgnoreCase(ansverAdd)) {
                            student.getSubjects().add(subject);
                            log.info("we add subject =  " + subject.getName());
                        } else if ("No".equalsIgnoreCase(ansverAdd)) {
                            log.info("we cannot add  subject =  " + subject.getName());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            log.error("Cannot find student with lastname  +  " + lastNameOfStuent);
        }
    }

    public void removeStudent() {
        log.info("Try to remove student");
        int idStudent = studentList.size();
        System.out.println("Delete student");
        int idOfStudent = Integer.parseInt(sc.next());
        try {
            studentList.remove(idOfStudent);
            if (idStudent > studentList.size()) {
                log.info("Everything ok. We remove our student");
            }
        } catch (Exception ex) {
            log.error("Cannot remove student with number " + idOfStudent);
        }
    }

    public Student getStudentById(long id) {
        return studentList.get((int) id);
    }

    public void saveSubject() {
        try {
            log.info("Try to save new subject");
            System.out.println("Please enter name of subject");
            String nameOfSubject = sc.next();
            Subject subject = new Subject(getAllSubject().size() + 1, nameOfSubject);
            if (subject.validate().isEmpty()) {
                subjectList.add(subject);
                log.info("Subject saved");
            } else {
                for (Map.Entry<String, String> map : subject.validate().entrySet()) {
                    System.out.println(map.getValue() + ". False: " + map.getKey());
                }
                System.out.println("You input incorrect data.Please try again.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateSubject() {
        log.info("Try to update subject");
        System.out.println("Lets find subject who will be update");
        String nameSubject = sc.next();
        String oldSubject = null;
        try {
            for (Subject subject : subjectList) {
                if (subject.getName().equals(nameSubject)) {
                    oldSubject = nameSubject;
                    try {
                        log.info("try to change name of subject");
                        System.out.println("Please enter another name of subject");
                        String name = sc.next();
                        subject.setName(name);
                        if (!subject.getName().equals(oldSubject)) {
                            log.info("Subject updated");
                        }
                    } catch (Exception ex) {
                        log.error("Subject with name" + nameSubject + " cannot update");
                    }
                }
            }
        } catch (Exception ex) {
            log.error("Subject with name " + oldSubject + "cannot update");
        }
    }

    public void removeSubject() {
        log.info("Try to remove subject");
        int idSubject = subjectList.size();
        System.out.println("Delete subject");
        int idOfSubject = Integer.parseInt(sc.next());
        try {
            subjectList.remove(idOfSubject);
            if (idSubject > subjectList.size()) {
                log.info("Everything ok. We remove our subject");
            }
        } catch (Exception ex) {
            log.error("Cannot remove subject with number " + idOfSubject);
        }
    }


    public void deleteSubjectById(long id) {
        subjectList.remove(id);
    }

    public Subject getSubjectById(long id) {
        return subjectList.get((int) id);
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