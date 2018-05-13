package com.addictionFitnessCenter.Timetable;

import com.addictionFitnessCenter.Timetable.model.Workout;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public interface TimetableService {

    Collection<Workout> getAll();

    Workout addWorkout (Workout workout) throws IllegalArgumentException;

    void removeById(Integer id);
}
