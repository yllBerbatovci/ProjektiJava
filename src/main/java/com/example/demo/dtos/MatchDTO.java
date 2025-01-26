package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MatchDTO {
    private Long id;
    private String homeTeam;
    private String awayTeam;
    private LocalDate matchDate;
    private int homeScore;
    private int awayScore;
}
