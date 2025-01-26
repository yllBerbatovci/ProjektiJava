package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    private Long matchId;
    private Long homeTeamId;
    private Long awayTeamId;
    private Date matchDate;
    private int homeScore;
    private int awayScore;
    private Long leagueId; // Ensure this matches the argument being passed
}
