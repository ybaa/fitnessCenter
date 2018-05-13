package com.addictionFitnessCenter.User.model;

import javax.persistence.Entity;

import com.addictionFitnessCenter.UserType.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "Userr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id = null;

    @Column(nullable = false)
    private String FirstName;

    @Column(nullable = false)
    private String LastName;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Password;
//
//    @Column(nullable = false)
//    private UserType UserType;

}
