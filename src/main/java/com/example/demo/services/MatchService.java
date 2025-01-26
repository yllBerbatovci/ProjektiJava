package com.example.demo.services;

import com.example.demo.dtos.MatchDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public List<MatchDTO> getMatchesForHomePage() {
        List<Match> matches = matchRepository.findAll(); // Adjust query as needed
        return matches.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public List<MatchDTO> getMatchesByLeague(String leagueName) {
        List<Match> matches = matchRepository.findByLeagueName(leagueName);
        return matches.stream().map(this::convertToDTO).collect(Collectors.toList());
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
}
