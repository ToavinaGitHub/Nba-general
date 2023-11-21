package com.nba.nbaws.controller;


import com.nba.nbaws.Entity.ActionMatchJoueur;
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


    @GetMapping("/statistiques/joueurs/{idJoueur}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Statistique getStat(@PathVariable int idJoueur){

        Joueur j = jr.findByIdJoueur(idJoueur);

        int countMatch = jr.matchJoue(j);
        int tirMaty = jr.totalTirMaty(idJoueur);

        Vector<ActionMatchJoueur> allTir = jr.getAllTir(j.getIdJoueur());

        System.out.println(tirMaty);

        Statistique st = new Statistique();
        try{st.setPointParMatch(jr.pointMoyenneParMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setPointParMatch(0);}


        st.setJoueur(j);
        try{st.setMatchJoue(countMatch);}catch (Exception e){st.setMatchJoue(0);};

        System.out.println(4+"----------------");
        try{st.setLf(jr.lf(j.getIdJoueur(),tirMaty));} catch(Exception e){st.setLf(0);};

        try{st.setThree(jr.three(j.getIdJoueur(),tirMaty));}catch (Exception e){st.setThree(0);}
        try{st.setRebondParMatch(jr.rebondMoyenneParMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setRebondParMatch(0);}
        try{st.setPasseDecisiveParMatch(jr.passeDecisive(j.getIdJoueur(),countMatch));}catch (Exception e){st.setPasseDecisiveParMatch(0);}
        try{st.setDesactive(tirMaty*2);}catch (Exception e){st.setDesactive(0);}

        System.out.println("tir maty:"+tirMaty);
        System.out.println("all :"+allTir.size());

        double fg = (double) tirMaty/allTir.size();

        try{st.setFg(fg*100);if(Double.isNaN(st.getFg())){st.setFg(0);}}catch (Exception e){st.setFg(0);}

        try{st.setMinuteParMatch(jr.getMinuteMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setMinuteParMatch(0);}

        return st;
    }

    @GetMapping("/statistiques")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Statistique> getStats(){

        ArrayList<Joueur> allJ = (ArrayList<Joueur>)  jr.findAll();

        Vector<Statistique> all = new Vector<Statistique>();

        System.out.println(1+"----------------");
        for (Joueur j : allJ
             ) {

            System.out.println(2+"----------------");
            int countMatch = jr.matchJoue(j);
            int tirMaty = jr.totalTirMaty(j.getIdJoueur());

            Vector<ActionMatchJoueur> allTir = jr.getAllTir(j.getIdJoueur());
            System.out.println(tirMaty);

            System.out.println(3+"----------------");
            Statistique st = new Statistique();
            try{st.setPointParMatch(jr.pointMoyenneParMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setPointParMatch(0);}

            st.setJoueur(j);
            try{st.setMatchJoue(countMatch);}catch (Exception e){st.setMatchJoue(0);};

            System.out.println(4+"----------------");
            try{st.setLf(jr.lf(j.getIdJoueur(),tirMaty));} catch(Exception e){st.setLf(0);};

            try{st.setThree(jr.three(j.getIdJoueur(),tirMaty));}catch (Exception e){st.setThree(0);}
            try{st.setRebondParMatch(jr.rebondMoyenneParMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setRebondParMatch(0);}
            try{st.setPasseDecisiveParMatch(jr.passeDecisive(j.getIdJoueur(),countMatch));}catch (Exception e){st.setPasseDecisiveParMatch(0);}
            try{st.setDesactive(tirMaty*2);}catch (Exception e){st.setDesactive(0);}

            try{st.setMinuteParMatch(jr.getMinuteMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setMinuteParMatch(0);}

            double fg = (double) tirMaty/allTir.size();

            try{st.setFg(fg*100);if(Double.isNaN(st.getFg())){st.setFg(0);}}catch (Exception e){st.setFg(0);}

            System.out.println(5+"----------------");
            all.add(st);
        }

        return all;
    }

    @GetMapping("/statistiques/equipes/{idEquipe}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Vector<Statistique> getStatParEquipe(@PathVariable int idEquipe){

        ArrayList<Joueur> allJ = (ArrayList<Joueur>)  jr.findJoueurByEquipe(eq.findByIdEquipe(idEquipe));
        Vector<Statistique> all = new Vector<Statistique>();

        System.out.println(1+"----------------");
        for (Joueur j : allJ
        ) {

            System.out.println(2+"----------------");
            int countMatch = jr.matchJoue(j);
            int tirMaty = jr.totalTirMaty(j.getIdJoueur());
            Vector<ActionMatchJoueur> allTir = jr.getAllTir(j.getIdJoueur());
            System.out.println(tirMaty);

            System.out.println(3+"----------------");
            Statistique st = new Statistique();
            try{st.setPointParMatch(jr.pointMoyenneParMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setPointParMatch(0);}

            st.setJoueur(j);
            try{st.setMatchJoue(countMatch);}catch (Exception e){st.setMatchJoue(0);};

            System.out.println(4+"----------------");
            try{st.setLf(jr.lf(j.getIdJoueur(),tirMaty));} catch(Exception e){st.setLf(0);};

            try{st.setThree(jr.three(j.getIdJoueur(),tirMaty));}catch (Exception e){st.setThree(0);}
            try{st.setRebondParMatch(jr.rebondMoyenneParMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setRebondParMatch(0);}
            try{st.setPasseDecisiveParMatch(jr.passeDecisive(j.getIdJoueur(),countMatch));}catch (Exception e){st.setPasseDecisiveParMatch(0);}
            try{st.setDesactive(tirMaty*2);}catch (Exception e){st.setDesactive(0);}


            try{st.setMinuteParMatch(jr.getMinuteMatch(j.getIdJoueur(),countMatch));}catch (Exception e){st.setMinuteParMatch(0);}


            double fg = (double) tirMaty/allTir.size();
            try{st.setFg(fg*100);if(Double.isNaN(st.getFg())){st.setFg(0);}}catch (Exception e){st.setFg(0);}
            System.out.println(5+"----------------");
            all.add(st);
        }

        return all;
    }






}
