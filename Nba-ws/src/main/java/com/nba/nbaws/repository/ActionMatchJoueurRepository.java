package com.nba.nbaws.repository;

import com.nba.nbaws.Entity.Action;
import com.nba.nbaws.Entity.ActionMatchJoueur;
import com.nba.nbaws.Entity.Joueur;
import com.nba.nbaws.Entity.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ActionMatchJoueurRepository extends CrudRepository<ActionMatchJoueur,Integer> {
    public List<ActionMatchJoueur> findByMatchAndJoueurAndAction(Match match, Joueur joueur, Action action);

 
}

