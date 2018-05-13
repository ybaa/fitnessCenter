package com.addictionFitnessCenter.Timetable.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Workout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id = null;

    @Column(nullable = false)
    private Date StartTime;

    @Column(nullable = false)
    private Date EndTime;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private String Location;

    @Column(nullable = false)
    private Integer Places;

    @Column(nullable = true)
    private Integer InstructorId = null;

    @Column(nullable = true)
    private Integer WorkoutUserId = null;


}
