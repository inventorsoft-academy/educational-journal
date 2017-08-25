package com.perepelitsya.controller;

import com.perepelitsya.model.Subject;
import com.perepelitsya.service.impls.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Andriu on 8/25/2017.
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "subject")
public class SubjectController {

    private ManagerService managerService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Subject> getAll() {
        return managerService.getAllSubject();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        managerService.saveSubject();
        return new ResponseEntity<Subject>(HttpStatus.OK);
    }

    @RequestMapping(value = "deleteBy{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Subject> delete(@PathVariable("id") long id) {
        try {
            managerService.deleteSubjectById(id);
        } catch (Exception e) {
            return new ResponseEntity<Subject>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Subject>(HttpStatus.CREATED);

    }


    @RequestMapping(value = "getBy{id}", method = RequestMethod.GET)
    public ResponseEntity<Subject> getById(@PathVariable("id") long id) {
        try {
            managerService.getSubjectById(id);
        } catch (Exception e) {
            return new ResponseEntity<Subject>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Subject>(HttpStatus.CREATED);
    }


}
