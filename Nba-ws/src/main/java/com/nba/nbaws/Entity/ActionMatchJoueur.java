package com.nba.nbaws.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "actionMatchJoueur")
public class ActionMatchJoueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idActMatchJoueur;

    @ManyToOne
    @JoinColumn(name = "joueur")
    Joueur joueur;
    @ManyToOne
    @JoinColumn(name = "match")
    Match match;

    @ManyToOne
    @JoinColumn(name = "action")
    Action action;

    int etat;
    /*
        Tir : 1 2 3
        Passe : -1(intercepté) 1(passe) 5(decisif)

    */

    double temps;

    public int getIdActMatchJoueur() {
        return idActMatchJoueur;
    }

    public void setIdActMatchJoueur(int idActMatchJoueur) {
        this.idActMatchJoueur = idActMatchJoueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public double getTemps() {
        return temps;
    }

    public void setTemps(double temps) {
        this.temps = temps;
    }

    public ActionMatchJoueur(int idActMatchJoueur, Joueur joueur, Match match, Action action, int etat, double temps) {
        this.idActMatchJoueur = idActMatchJoueur;
        this.joueur = joueur;
        this.match = match;
        this.action = action;
        this.etat = etat;
        this.temps = temps;
    }

    public ActionMatchJoueur() {
    }
}
