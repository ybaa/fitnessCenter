package com.addictionFitnessCenter.Timetable.impl;

import com.addictionFitnessCenter.Timetable.TimetableService;
import com.addictionFitnessCenter.Timetable.model.Workout;
import com.addictionFitnessCenter.Timetable.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TimetableImplementation implements TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;


    @Override
    public Collection<Workout> getAll() {
        return StreamSupport.stream(timetableRepository.findAll().spliterator(), false).
                collect(Collectors.toList());
    }

    @Override
    public Workout addWorkout(Workout workout) throws IllegalArgumentException {
        if(workout.getId() == null || !timetableRepository.existsById(workout.getId())) {
            try {
                return timetableRepository.save(workout);
            }
            catch (DataAccessException e){
                throw  new IllegalArgumentException(e);
            }
        }else
            throw new IllegalArgumentException("Reservation already exists");
    }

    @Override
    public void removeById(Integer id) {
        timetableRepository.deleteById(id);
    }
}
