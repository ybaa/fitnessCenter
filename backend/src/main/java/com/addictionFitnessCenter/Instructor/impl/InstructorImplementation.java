package com.addictionFitnessCenter.Instructor.impl;


import com.addictionFitnessCenter.Instructor.InstructorService;
import com.addictionFitnessCenter.Instructor.model.Instructor;
import com.addictionFitnessCenter.Instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class InstructorImplementation implements InstructorService {


        @Autowired
        private InstructorRepository instructorRepository;

        @Override
        public Collection<Instructor> getAll() {
            return StreamSupport.stream(instructorRepository.findAll().spliterator(), false).
                    collect(Collectors.toList());
        }

    @Override
    public Instructor addInstructor(Instructor instructor) throws IllegalArgumentException {
        if(instructor.getId() == null || !instructorRepository.existsById(instructor.getId())) {
            try {
                return instructorRepository.save(instructor);
            }
            catch (DataAccessException e){
                throw  new IllegalArgumentException(e);
            }
        }else
            throw new IllegalArgumentException("Reservation does already exist");
    }
    }
