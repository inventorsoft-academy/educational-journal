package com.perepelitsya.demo;

import com.perepelitsya.service.impls.FileManagerService;
import com.perepelitsya.service.impls.JsonManagerService;
import com.perepelitsya.service.impls.ManagerService;
import com.perepelitsya.service.interfaces.FileManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Andriu on 8/14/2017.
 */
public class Run {

    private final static Logger log = Logger.getLogger(Run.class);

    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    ManagerService Nataly = new ManagerService();


    public void init() throws IOException {
        while (flag) {
            System.out.println("\n1 - Create new Student\n2 - Update Student\n3 - Delete Student\n4 - Create new Subject\n" +
                    "5 - Update Subject\n6 - Delete Subject\n7 - GetAllStudent\n8 - GetAllSubject\n" +
                    "9 - Work with file and Json");

            switch (sc.nextInt()) {
                case 1:
                    if (!Nataly.getAllSubject().isEmpty()) {
                        Nataly.saveStudent();
                    } else {
                        System.out.println("Please enter first of all subjects");
                        Nataly.saveSubject();
                    }
                    break;
                case 2:
                    Nataly.updateStudent();
                    break;
                case 3:
                    Nataly.removeStudent();
                    break;
                case 4:
                    Nataly.saveSubject();
                    break;
                case 5:
                    Nataly.updateSubject();
                    break;
                case 6:
                    Nataly.removeSubject();
                    break;

                case 7:
                    System.out.println(Nataly.getAllStudent());
                    break;

                case 8:
                    System.out.println(Nataly.getAllSubject());
                    break;

                case 9:
                    boolean flagForFile = true;

                    while (flagForFile) {
                        System.out.println("1 - Write&Read to Txt\n2 - Write&Read to Json");
                        String name = sc.next();
                        if (name.equalsIgnoreCase("txt")) {
                            FileManager Igor = new FileManagerService();
                            System.out.println("1-Write to file student\n2-Read from file studet\n3-Write to file subject\n" +
                                    "4-Read from file subject");
                            switch (sc.nextInt()) {
                                case 1:
                                    Igor.writeToFileStudent(Nataly.getAllStudent());
                                    break;

                                case 2:
                                    System.out.println(Igor.readFromFileStudent());
                                    break;

                                case 3:
                                    Igor.writeToFileSubject(Nataly.getAllSubject());
                                    break;

                                case 4:
                                    System.out.println(Igor.readFromFileSubject());
                                    break;
                                default:
                                    System.out.println("Cannot understand");
                            }
                        } else if (name.equalsIgnoreCase("json")) {

                            FileManager Igor = new JsonManagerService();
                            System.out.println("1-Write to json student\n2-Read from json studet\n3-Write to json subject\n" +
                                    "4-Read from json subject");
                            switch (sc.nextInt()) {
                                case 1:
                                    Igor.writeToFileStudent(Nataly.getAllStudent());
                                    break;

                                case 2:
                                    System.out.println(Igor.readFromFileStudent());
                                    break;

                                case 3:
                                    Igor.writeToFileSubject(Nataly.getAllSubject());
                                    break;

                                case 4:
                                    System.out.println(Igor.readFromFileSubject());

                                    break;
                                default:
                                    System.out.println("Dont understand");
                            }
                        } else {
                            flagForFile = false;
                        }
                    }

                case 10:
                    flag = false;
                    log.info("!!!!!!!!!!!!Close our programm!!!!!!");

                default:
                    System.out.println("Incorrect");
            }
        }
    }
}