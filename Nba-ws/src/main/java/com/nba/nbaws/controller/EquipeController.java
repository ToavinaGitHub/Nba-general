package com.nba.nbaws.controller;

import com.nba.nbaws.Entity.Equipe;
import com.nba.nbaws.Entity.Joueur;
import com.nba.nbaws.Entity.Match;
import com.nba.nbaws.repository.EquipeRepository;
import com.nba.nbaws.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipeController {

    @Autowired
    EquipeRepository equipe;
    @Autowired
    JoueurRepository joueurRepository;

    @GetMapping("/equipes")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Equipe> getAll(){
        return equipe.findAll();
    }

    @GetMapping("/equipes/joueurs/{e}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Joueur> joueursParEquipe(@PathVariable int e){

        Equipe eq = equipe.findByIdEquipe(e);

        List<Joueur> all = joueurRepository.findJoueurByEquipe(eq);
        return all;
    }


    @GetMapping("/equipes/matchs/{idEquipe}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Match> matchJouer(@PathVariable int idEquipe){
        List<Match> all = equipe.matchJoue(equipe.findByIdEquipe(idEquipe));
        return all;
    }


}
