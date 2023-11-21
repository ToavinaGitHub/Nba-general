package com.nba.nbaws.controller;

import com.nba.nbaws.Entity.Action;
import com.nba.nbaws.Entity.ActionMatchJoueur;
import com.nba.nbaws.repository.ActionMatchJoueurRepository;
import com.nba.nbaws.repository.ActionRepository;
import com.nba.nbaws.repository.JoueurRepository;
import com.nba.nbaws.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActionMatchJoueurController {

    @Autowired
    ActionMatchJoueurRepository ac;
    @Autowired
    MatchRepository mc;
    @Autowired
    JoueurRepository jc;
    @Autowired
    ActionRepository ar;


    @GetMapping("/actionMatchJoueurs/{match}/{joueur}/{action}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<ActionMatchJoueur> getAllActionByJoueurMatch(@PathVariable int match,@PathVariable int joueur,@PathVariable int action){
        List<ActionMatchJoueur> all = ac.findByMatchAndJoueurAndAction(mc.findByIdMatch(match),jc.findByIdJoueur(joueur),ar.findByIdAction(action));
        return all;
    }

    @PostMapping("/rebonds/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String insertRebondJoueurMatch(@RequestParam int idJoueur,@RequestParam int idMatch,@RequestParam double temps){

        Action action = ar.findByIdAction(3);

        ActionMatchJoueur a = new ActionMatchJoueur(1,jc.findByIdJoueur(idJoueur),mc.findByIdMatch(idMatch),action,1,temps);
        try{
            ac.save(a);
            return "{\"success\":1, \"message\":\"Rebond inséré avec succés\"}";
        }catch (Exception e){
            return "{\"success\":0, \"message\":\"Rebond non inséré\"}";
        }
    }
    @PostMapping("/passes/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String insertPasseJoueurMatch(@RequestParam int idJoueur,@RequestParam int idMatch,@RequestParam double temps){

        Action action = ar.findByIdAction(1);

        ActionMatchJoueur a = new ActionMatchJoueur(1,jc.findByIdJoueur(idJoueur),mc.findByIdMatch(idMatch),action,1,temps);
        try{
            ac.save(a);
            return "{\"success\":1, \"message\":\"Passe inséré avec succés\"}";
        }catch (Exception e){
            return "{\"success\":0, \"message\":\"Passe non inséré\"}";
        }
    }
    @PostMapping("/passeDecisives/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String insertPasseDecisiveJoueurMatch(@RequestParam int idJoueur,@RequestParam int idMatch,@RequestParam double temps){

        Action action = ar.findByIdAction(1);

        ActionMatchJoueur a = new ActionMatchJoueur(1,jc.findByIdJoueur(idJoueur),mc.findByIdMatch(idMatch),action,5,temps);
        try{
            ac.save(a);
            return "{\"success\":1, \"message\":\"Passe desisive inséré avec succés\"}";
        }catch (Exception e){
            return "{\"success\":0, \"message\":\"Passe decisive non inséré\"}";
        }
    }

    @PostMapping("/tirs/create/{point}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String insertTirJoueurMatch(@PathVariable int point, @RequestParam int idJoueur, @RequestParam int idMatch, @RequestParam double temps) {
        try {
            // Récupérer l'action correspondant au tir depuis la base de données
            Action action = ar.findByIdAction(2);

            // Créer une nouvelle instance d'ActionMatchJoueur avec l'action récupérée
            ActionMatchJoueur a = new ActionMatchJoueur(1, jc.findByIdJoueur(idJoueur), mc.findByIdMatch(idMatch), action, point, temps);

            // Enregistrer l'instance d'ActionMatchJoueur dans la base de données
            ac.save(a);

            return "{\"success\":1, \"message\":\"Tir inséré avec succès\"}";
        } catch (Exception e) {
            return "{\"success\":0, \"message\":\"Tir non inséré\"}";
        }
    }


    @PostMapping("/defenses/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String insertDefenseJoueurMatch(@RequestParam int idJoueur,@RequestParam int idMatch,@RequestParam double temps){

        Action action = ar.findByIdAction(4);

        ActionMatchJoueur a = new ActionMatchJoueur(1,jc.findByIdJoueur(idJoueur),mc.findByIdMatch(idMatch),action,1,temps);
        try{
            ac.save(a);
            return "{\"success\":1, \"message\":\"Defense inséré avec succés\"}";
        }catch (Exception e){
            return "{\"success\":0, \"message\":\"Defense non inséré\"}";
        }
    }

    @PostMapping("/lfs/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String insertLf(@RequestParam int idJoueur,@RequestParam int idMatch,@RequestParam double temps){

        Action action = ar.findByIdAction(5);

        ActionMatchJoueur a = new ActionMatchJoueur(1,jc.findByIdJoueur(idJoueur),mc.findByIdMatch(idMatch),action,1,temps);
        try{
            ac.save(a);
            return "{\"success\":1, \"message\":\"Lancée franc inséré avec succés\"}";
        }catch (Exception e){
            return "{\"success\":0, \"message\":\"Lancée franc non inséré\"}";
        }
    }
}
