package com.nba.nbaws.controller;

import com.nba.nbaws.Entity.Equipe;
import com.nba.nbaws.Entity.Joueur;
import com.nba.nbaws.Entity.Match;
import com.nba.nbaws.repository.EquipeRepository;
import com.nba.nbaws.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipeController {

    @Autowired
    EquipeRepository equipe;
    @Autowired
    JoueurRepository joueurRepository;

    @GetMapping("/equipes")
    public Iterable<Equipe> getAll(){
        return equipe.findAll();
    }

    @GetMapping("/equipes/joueurs/{e}")
    public Iterable<Joueur> joueursParEquipe(@PathVariable int e){

        Equipe eq = equipe.findByIdEquipe(e);

        List<Joueur> all = joueurRepository.findJoueurByEquipe(eq);
        return all;
    }

    @GetMapping("/equipes/matchs/{idEquipe}")
    public Iterable<Match> matchJouer(@PathVariable int idEquipe){
        List<Match> all = equipe.matchJoue(equipe.findByIdEquipe(idEquipe));
        return all;
    }


}
