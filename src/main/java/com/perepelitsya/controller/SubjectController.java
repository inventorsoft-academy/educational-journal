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
@RequestMapping(value = "/subjects")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,
        RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class SubjectController {

    private ManagerService managerService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Subject> getAll() {
        return managerService.getAllSubject();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        managerService.saveSubject(subject);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/{subjectId:\\d+}", method = RequestMethod.DELETE)
    public ResponseEntity<Subject> delete(@PathVariable long subjectId) {
        managerService.deleteSubjectById(subjectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{subjectId:\\d+}", method = RequestMethod.GET)
    public ResponseEntity<Subject> getById(@PathVariable long subjectId) {
        return new ResponseEntity<>(managerService.getSubjectById(subjectId), HttpStatus.OK);
    }
}
