package com.addictionFitnessCenter.Instructor;

import com.addictionFitnessCenter.Instructor.model.Instructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface InstructorService {

    Collection<Instructor> getAll();

    Instructor addInstructor(Instructor instructor) throws IllegalArgumentException;
}
