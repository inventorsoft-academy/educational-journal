package com.perepelitsya.controller;

import com.perepelitsya.model.Student;
import com.perepelitsya.service.impls.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Andriu on 8/22/2017.
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "student")
public class StudentController {

    private ManagerService managerService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> getAll() {
        return managerService.getAllStudent();
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        managerService.saveStudent();
        return new ResponseEntity<Student>(HttpStatus.OK);
    }


    @RequestMapping(value = "deleteBy{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> delete(@PathVariable("id") long id) {
        try {
            managerService.deleteStudentById(id);
        } catch (Exception e) {
            return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Student>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "getBy{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getById(@PathVariable("id") long id) {
        try {
            managerService.getStudentById(id);
        } catch (Exception e) {
            return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Student>(HttpStatus.CREATED);
    }

}
