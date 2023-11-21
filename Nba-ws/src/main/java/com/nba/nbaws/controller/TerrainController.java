package com.nba.nbaws.controller;

import com.nba.nbaws.Entity.Terrain;
import com.nba.nbaws.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TerrainController {

    @Autowired
    TerrainRepository terrain;

    @GetMapping("/terrains")

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Terrain> getAll(){
        return terrain.findAll();
    }
}
