package com.example.demo.services;

import com.example.demo.dtos.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    public List<TeamDTO> getTeamsByLeagueId(Long leagueId) {
        return (leagueId == 1L)
                ? List.of(
                new TeamDTO(1L, "Liverpool", "/logos/liverpool.png", leagueId),
                new TeamDTO(2L, "Arsenal", "/logos/arsenal.png", leagueId),
                new TeamDTO(3L, "Nottingham Forest", "/logos/nottingham_forest.png", leagueId)
        )
                : List.of(
                new TeamDTO(4L, "Barcelona", "/logos/barcelona.png", leagueId),
                new TeamDTO(5L, "Atletico Madrid", "/logos/atletico_madrid.png", leagueId),
                new TeamDTO(6L, "Real Madrid", "/logos/real_madrid.png", leagueId)
        );
    }
}
