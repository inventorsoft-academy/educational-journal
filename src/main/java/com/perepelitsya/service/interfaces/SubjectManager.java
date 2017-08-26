package com.perepelitsya.service.interfaces;

import com.perepelitsya.model.Subject;

import java.util.List;

/**
 * Created by Andriu on 8/21/2017.
 */
public interface SubjectManager {

    void saveSubject(Subject subject);

    Subject getSubjectById(long id);

    void deleteSubjectById(long id);

    List<Subject> getAllSubject();

}