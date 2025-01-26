package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Match {
    @Id
    private Long id;
    private String leagueName;
    private String teamName;
    private String matchDate;
    // Add fields, getters, setters, and constructors
}
