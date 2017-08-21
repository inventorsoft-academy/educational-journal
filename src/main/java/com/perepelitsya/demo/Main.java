package com.perepelitsya.demo;



import org.apache.log4j.Logger;

import java.io.IOException;
import java.time.LocalDateTime;


/**
 * Created by Andriu on 8/14/2017.
 */
public class Main {
    private final static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        log.info("!!!!!!!!!!!Programm started!!!!!!!!!!!" + LocalDateTime.now());
        try {
            new Run().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
