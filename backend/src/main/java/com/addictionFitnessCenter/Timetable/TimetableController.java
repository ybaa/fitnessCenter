package com.addictionFitnessCenter.Timetable;

import com.addictionFitnessCenter.Timetable.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/timetable")
public class TimetableController {

    @Autowired
    TimetableService timetableService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<Workout> getTimetable(){
        return timetableService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Workout> addTimetable(@RequestBody Workout workout) {
        try {
            return new ResponseEntity<>(timetableService.addWorkout(workout), HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/{Id}",method=RequestMethod.DELETE)
    public @ResponseBody void deleteTimetable(@PathVariable Integer Id) {
        timetableService.removeById(Id);
    }

}
