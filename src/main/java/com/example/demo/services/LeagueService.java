package com.example.demo.services;

import com.example.demo.dtos.MatchDTO;
import com.example.demo.dtos.StandingDTO;
import com.example.demo.entities.Match;
import com.example.demo.entities.Standing;
import com.example.demo.repositories.MatchRepository;
import com.example.demo.repositories.StandingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private StandingRepository standingRepository;

    public List<MatchDTO> getTodayMatches(String leagueName) {
        LocalDate today = LocalDate.now();
        List<Match> matches = matchRepository.findByLeagueNameAndDate(leagueName, today);
        return matches.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<MatchDTO> getPastMatches(String leagueName) {
        LocalDate today = LocalDate.now();
        LocalDate threeDaysAgo = today.minusDays(3);
        List<Match> matches = matchRepository.findByLeagueNameAndDateRange(leagueName, threeDaysAgo, today.minusDays(1));
        return matches.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<MatchDTO> getUpcomingMatches(String leagueName) {
        LocalDate today = LocalDate.now();
        LocalDate threeDaysLater = today.plusDays(3);
        List<Match> matches = matchRepository.findByLeagueNameAndDateRange(leagueName, today.plusDays(1), threeDaysLater);
        return matches.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<StandingDTO> getStandings(String leagueName) {
        List<Standing> standings = standingRepository.findByLeagueName(leagueName);
        return standings.stream().map(this::convertToStandingDTO).collect(Collectors.toList());
    }

    private MatchDTO convertToDTO(Match match) {
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setHomeTeam(match.getHomeTeam().getName());
        dto.setAwayTeam(match.getAwayTeam().getName());
        dto.setMatchDate(match.getMatchDate());
        dto.setHomeScore(match.getHomeScore());
        dto.setAwayScore(match.getAwayScore());
        return dto;
    }

    private StandingDTO convertToStandingDTO(Standing standing) {
        StandingDTO dto = new StandingDTO();
        dto.setPosition(standing.getPosition());
        dto.setTeamName(standing.getTeam().getName());
        dto.setPoints(standing.getPoints());
        return dto;
    }
}

