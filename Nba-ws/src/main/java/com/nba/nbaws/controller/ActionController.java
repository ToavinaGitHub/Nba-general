package com.nba.nbaws.controller;

import com.nba.nbaws.Entity.Action;
import com.nba.nbaws.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController {

    @Autowired
    ActionRepository action;

    @GetMapping("/actions")
    public Iterable<Action> getAll(){
        return action.findAll();
    }
}
