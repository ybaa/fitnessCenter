package com.addictionFitnessCenter.UserType.model;

import javax.persistence.Entity;
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
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id = null;

    @Column(nullable = false)
    private String Name;
}
