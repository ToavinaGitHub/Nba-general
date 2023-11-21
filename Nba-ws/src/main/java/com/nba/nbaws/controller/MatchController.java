package com.nba.nbaws.controller;

import com.nba.nbaws.Entity.Match;
import com.nba.nbaws.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @Autowired
    MatchRepository match;


    @GetMapping("/matchs")
    public Iterable<Match> getAll(){
        return match.findAll();
    }


}
