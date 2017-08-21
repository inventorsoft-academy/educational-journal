package com.perepelitsya.service.impls;

import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;
import com.perepelitsya.service.interfaces.FileManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileManagerService implements FileManager {

    private final static Logger log = Logger.getLogger(FileManagerService.class);
    private static final String INPUT = "C:\\Users\\Andriu\\Desktop\\educational-journal\\src\\main\\resources\\Students.txt";
    private static final String INPUTSUBJECT = "C:\\Users\\Andriu\\Desktop\\educational-journal\\src\\main\\resources\\Subjects.txt";

    File fileWriter = new File(INPUT);
    File fileWriterSubject = new File(INPUTSUBJECT);

    BufferedWriter writer;
    BufferedReader reader;

    private ManagerService managerService = new ManagerService();





    @Override
    public void writeToFileSubject(List<Subject> subjectList) {
        try {
            log.info("Try to write list of subjects to file Subjects.txt");
            writer = new BufferedWriter(new FileWriter(fileWriterSubject, true));
            StringBuilder line = new StringBuilder();
            for (Subject subject : subjectList) {
                line.append(subject.getIdOfSubject())
                        .append("/")
                        .append(subject.getName())
                        .append("/");
                writer.append(line.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
            log.info("Students are in file");
        } catch (IOException ex) {
            log.info("Cannot to write list of subjects to file Subjects.txt" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void writeToFileStudent(List<Student> studentList) {
        try {
            log.info("Try to write list of students to file Students.txt");
            writer = new BufferedWriter(new FileWriter(fileWriter, true));
            StringBuilder line = new StringBuilder();
            StringBuilder sub = new StringBuilder();
            for (Student student : studentList) {
                for (Subject a : student.getSubjects()) {
                    sub.append(a)
                            .append(" , ");
                }
                line.append(student.getId())
                        .append("/")
                        .append(student.getFirstName())
                        .append("/")
                        .append(student.getLastName())
                        .append("/")
                        .append(student.getBirthDay())
                        .append("/")
                        .append(student.getGroup())
                        .append("/")
                        .append(student.getMark())
                        .append("/")
                        .append(sub)
                        .append("\n");
                writer.append(line.toString());
            }
            writer.newLine();
            writer.flush();
            writer.close();
            log.info("Subjects are in file");
        } catch (IOException ex) {
            log.error("Cannot  to write list of students to file Students.txt" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public List<Student> readFromFileStudent() {
        log.info("try ro read students from file");
        List<Student> studentList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileWriter));
            String s;
            String[] line;
            while ((s = reader.readLine()) != null) {
                line = s.split("/");
                studentList.add(new Student(Integer.parseInt(line[1]), String.valueOf(line[2]), String.valueOf(line[3]), LocalDateTime.parse(line[4]),
                        Integer.parseInt(line[5]), LocalDateTime.parse(line[6]), List.class.cast(line[7])));
            }
            log.info("Our student in list");
        } catch (IOException e) {
            log.error("We cannot read our subjects");
            e.printStackTrace();

        }
        return studentList;
    }

    @Override
    public List<Subject> readFromFileSubject() {
        log.info("try ro read subjects from file");
        List<Subject> subjectList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileWriterSubject));
            String subject;
            String[] line;
            while ((subject = reader.readLine()) != null) {
                line = subject.split("/");
                subjectList.add(new Subject(Integer.parseInt(line[1]), line[2]));
            }
            log.info("We read all our subjects to list subjects");
        } catch (IOException | NumberFormatException ex) {
            log.error("We cannot read our subjects");
            ex.printStackTrace();
        }
        return subjectList;
    }
}