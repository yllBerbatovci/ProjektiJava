package com.example.demo.repositories;

import com.example.demo.entities.Standing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StandingRepository extends JpaRepository<Standing, Long> {
    List<Standing> findByLeagueName(String leagueName);
}
