package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Standing {
    @Id
    private Long id;
    private String leagueName;
    private Integer points;
    // Add fields, getters, setters, and constructors
}
