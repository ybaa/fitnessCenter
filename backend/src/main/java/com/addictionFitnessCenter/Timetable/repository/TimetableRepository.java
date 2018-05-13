package com.addictionFitnessCenter.Timetable.repository;

import com.addictionFitnessCenter.Timetable.model.Workout;
import org.springframework.data.repository.CrudRepository;

public interface TimetableRepository extends CrudRepository<Workout, Integer>  {

}
