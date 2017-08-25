package com.perepelitsya.custom;

import lombok.Getter;
import lombok.Setter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Andriu on 8/25/2017.
 */
public class MyLog4J {

    DateTimeFormatter formatToMyLogger = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static final String CONSOLE = "console";
    public static final String TO_FILE = "file";
    public static final String CONSOLE_FILE = "console, file";

    public MyLog4J(String path) {
        this.path = path;
    }

    private String path = null;

    @Setter
    @Getter
    private String level = TO_FILE;


    public void info(String message) {
        String log = LocalDateTime.now().format(formatToMyLogger) + " |Class: " + getClass().getSimpleName() +
                " |Package: " + getClass().getPackage() + " |Info: " + " --- " + message;
        if (level.equals(TO_FILE) || level.equals(CONSOLE_FILE)) {
            write(log);
        }
        if (level.equals(CONSOLE) || level.equals(CONSOLE_FILE)) {
            System.out.println(log);
        }
    }

    public void error(String message) {
        String log = LocalDateTime.now().format(formatToMyLogger) + " |Class: " + getClass().getSimpleName() +
                " |Package: " + getClass().getPackage() + " |Error: " + " --- " + message;
        if (level.equals(TO_FILE) || level.equals(CONSOLE_FILE)) {
            write(log);
        }
        if (level.equals(CONSOLE) || level.equals(CONSOLE_FILE)) {
            System.out.println(log);
        }
    }

    public void warn(String message) {
        String log = LocalDateTime.now().format(formatToMyLogger) + " |Class: " + getClass().getSimpleName() +
                " |Package: " + getClass().getPackage() + " |Warning: " + " --- " + message;
        if (level.equals(TO_FILE) || level.equals(CONSOLE_FILE)) {
            write(log);
        }
        if (level.equals(CONSOLE) || level.equals(CONSOLE_FILE)) {
            System.out.println(log);
        }
    }

    public void debug(String message) {
        String log = LocalDateTime.now().format(formatToMyLogger) + " |Class: " + getClass().getSimpleName() +
                " |Package: " + getClass().getPackage() + " |Debug: " + " --- " + message;
        if (level.equals(TO_FILE) || level.equals(CONSOLE_FILE)) {
            write(log);
        }
        if (level.equals(CONSOLE) || level.equals(CONSOLE_FILE)) {
            System.out.println(log);
        }
    }

    private void write(String message) {
        try (FileOutputStream fos = new FileOutputStream(path);
             PrintStream printStream = new PrintStream(fos)) {
            printStream.println(message);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
