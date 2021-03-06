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
@RequestMapping(value = "/students")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,
        RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class StudentController {

    private ManagerService managerService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> getAll() {
        return managerService.getAllStudent();
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        managerService.saveStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> addMarkToStudent( @PathVariable long id,
                                                     @RequestParam(value = "subject_id", required = true) long subject_id,
                                                     @RequestParam(value="mark", required=true) int mark) {
        managerService.addMarksToStudent(id, subject_id,  mark);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{studentId:\\d+}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> delete(@PathVariable long studentId) {
        managerService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{studentId:\\d+}", method = RequestMethod.GET)
    public ResponseEntity<Student> getById(@PathVariable long studentId) {
        return new ResponseEntity<>(managerService.getStudentById(studentId), HttpStatus.OK);
    }

}
