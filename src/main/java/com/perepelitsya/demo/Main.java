package com.perepelitsya.demo;

import com.perepelitsya.service.impls.JsonManagerService;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by Andriu on 8/14/2017.
 */
//@SpringBootApplication
public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        try {
            new Run().init();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
