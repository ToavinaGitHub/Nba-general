package com.nba.nbaws.controller;


import com.nba.nbaws.Entity.Joueur;
import com.nba.nbaws.Entity.Statistique;
import com.nba.nbaws.repository.EquipeRepository;
import com.nba.nbaws.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@RestController
public class JoueurController {

    @Autowired
    JoueurRepository jr;

    @Autowired
    EquipeRepository eq;

    @GetMapping("/joueurs")

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public Iterable<Joueur> getAll(){
        return jr.findAll();
    }


    @GetMapping("/statistiques/{idJoueur}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Statistique getStat(@PathVariable int idJoueur){

        Joueur j = jr.findByIdJoueur(idJoueur);

        int countMatch = jr.matchJoue(j);
        int tirMaty = jr.totalTirMaty(idJoueur);

        System.out.println(tirMaty);

        Statistique st = new Statistique();
        st.setPointParMatch(jr.pointMoyenneParMatch(idJoueur,countMatch));
        st.setJoueur(j);
        st.setMatchJoue(countMatch);

        st.setLf(jr.lf(idJoueur,tirMaty));

        st.setThree(jr.three(idJoueur,tirMaty));
        st.setRebondParMatch(jr.rebondMoyenneParMatch(idJoueur,countMatch));
        st.setPasseDecisiveParMatch(jr.passeDecisive(idJoueur,countMatch));
        st.setDesactive(tirMaty*2);
        return st;
    }

    @GetMapping("/statistiques")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Statistique> getStats(){

        ArrayList<Joueur> allJ = (ArrayList<Joueur>)  jr.findAll();

        Vector<Statistique> all = new Vector<Statistique>();

        for (Joueur j : allJ
             ) {

            int countMatch = jr.matchJoue(j);
            int tirMaty = jr.totalTirMaty(j.getIdJoueur());

            System.out.println(tirMaty);

            Statistique st = new Statistique();
            st.setPointParMatch(jr.pointMoyenneParMatch(j.getIdJoueur(),countMatch));
            st.setJoueur(j);
            st.setMatchJoue(countMatch);

            st.setLf(jr.lf(j.getIdJoueur(),tirMaty));

            st.setThree(jr.three(j.getIdJoueur(),tirMaty));
            st.setRebondParMatch(jr.rebondMoyenneParMatch(j.getIdJoueur(),countMatch));
            st.setPasseDecisiveParMatch(jr.passeDecisive(j.getIdJoueur(),countMatch));
            st.setDesactive(tirMaty*2);

            all.add(st);
        }

        return all;
    }






}
