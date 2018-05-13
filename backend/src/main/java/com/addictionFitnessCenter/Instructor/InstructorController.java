package com.addictionFitnessCenter.Instructor;

import com.addictionFitnessCenter.Instructor.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/instructors")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<Instructor> getInstructors(){
        return instructorService.getAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        try {
            return new ResponseEntity<>(instructorService.addInstructor(instructor), HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
