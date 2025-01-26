package com.example.demo.controllers.api.v1;

import com.example.demo.dtos.TeamDTO;
import com.example.demo.dtos.MatchDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Date;

@Controller
public class LeagueController {

    @GetMapping("/league/{id}")
    public String leaguePage(@PathVariable Long id, Model model) {
        String leagueName = (id == 1L) ? "Premier League" : "La Liga";
        String country = (id == 1L) ? "England" : "Spain";

        List<TeamDTO> teams = List.of(
                new TeamDTO(1L, "Team 1", "/logos/team1.png", id),
                new TeamDTO(2L, "Team 2", "/logos/team2.png", id),
                new TeamDTO(3L, "Team 3", "/logos/team3.png", id)
        );

        List<MatchDTO> matches = List.of(
                new MatchDTO(1L, 1L, 2L, new Date(), 2, 1, id),
                new MatchDTO(2L, 3L, 1L, new Date(), 0, 0, id)
        );

        model.addAttribute("leagueName", leagueName);
        model.addAttribute("country", country);
        model.addAttribute("teams", teams);
        model.addAttribute("matches", matches);

        return "league";
    }
}
