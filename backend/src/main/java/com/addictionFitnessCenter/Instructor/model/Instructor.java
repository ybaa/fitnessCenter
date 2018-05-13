package com.addictionFitnessCenter.Instructor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id = null;

    @Column(nullable = false)
    private String FirstName;

    @Column(nullable = false)
    private String LastName;

    @Column(nullable = false)
    private String Description;




}
