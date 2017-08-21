package com.perepelitsya.service.interfaces;

import com.perepelitsya.model.Subject;

import java.util.List;

/**
 * Created by Andriu on 8/21/2017.
 */
public interface SubjectManager {
    void saveSubject();

    void updateSubject();

    void removeSubject();

    List<Subject> getAllSubject();

}
