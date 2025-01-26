package com.example.demo.controllers;

import com.example.demo.dtos.LeagueDTO;
import com.example.demo.dtos.MatchDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.example.demo.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {
    @Autowired
    private MatchService matchService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<MatchDTO> matches = matchService.getMatchesForHomePage();
        model.addAttribute("matches", matches);
        return "home";
    }
}