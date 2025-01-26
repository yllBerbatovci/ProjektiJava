package com.example.demo.controllers;

import com.example.demo.dtos.LeagueDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        List<LeagueDTO> leagues = List.of(
                new LeagueDTO(1L, "Premier League", "England"),
                new LeagueDTO(2L, "La Liga", "Spain")
        );
        model.addAttribute("leagues", leagues);
        return "home";
    }
}
