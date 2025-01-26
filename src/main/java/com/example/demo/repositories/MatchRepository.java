package com.example.demo.repositories;

import com.example.demo.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByLeagueNameAndDate(String leagueName, LocalDate date);
    List<Match> findByLeagueNameAndDateRange(String leagueName, LocalDate startDate, LocalDate endDate);
}
