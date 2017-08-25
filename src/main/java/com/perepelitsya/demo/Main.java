package com.perepelitsya.demo;

import com.perepelitsya.custom.MyLog4J;

import java.io.IOException;

/**
 * Created by Andriu on 8/14/2017.
 */

/**
 * Use my custom Logger
 */
public class Main {
    public static void main(String[] args) throws  IOException {
        MyLog4J log = new MyLog4J("src\\main\\resources\\sub.txt");
        log.setLevel(MyLog4J.CONSOLE_FILE);

        try {
            log.info("Programm started with my own logger");
            new Run().init();
            log.info("Programm closed!!!");
        } catch (IOException error) {
            log.error("You have some problem " + error.getMessage());
        }
    }
}
