package com.example.demo.services;

import com.example.demo.dtos.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    public List<TeamDTO> getTeamsByLeagueId(Long leagueId) {
        return List.of(
                new TeamDTO(1L, "Team 1", "/logos/team1.png", leagueId),
                new TeamDTO(2L, "Team 2", "/logos/team2.png", leagueId),
                new TeamDTO(3L, "Team 3", "/logos/team3.png", leagueId)
        );
    }
}
