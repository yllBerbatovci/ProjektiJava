package com.example.demo.controllers.api.v1;

import com.example.demo.dtos.MatchDTO;
import com.example.demo.services.MatchService;
import com.example.demo.dtos.StandingDTO;
import com.example.demo.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;




@Controller
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @GetMapping("/league/{leagueName}")
    public String leaguePage(@PathVariable String leagueName, Model model) {
        // Fetch data
        model.addAttribute("leagueName", leagueName);
        model.addAttribute("todayMatches", leagueService.getTodayMatches(leagueName));
        model.addAttribute("results", leagueService.getPastMatches(leagueName));
        model.addAttribute("fixtures", leagueService.getUpcomingMatches(leagueName));
        model.addAttribute("standings", leagueService.getStandings(leagueName));
        return "league";
    }
}

