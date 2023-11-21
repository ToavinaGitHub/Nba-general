package com.nba.nbaws.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "matchJoueur")
public class MatchJoueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMatchJoueur;

    @ManyToOne
    @JoinColumn(name = "match")
    Match match;

    @ManyToOne
    @JoinColumn(name = "joueur")
    Joueur joueur;

    double tempsJeu;

    public MatchJoueur() {
    }

    public MatchJoueur(int idMatchJoueur, Match match, Joueur joueur, double tempsJeu) {
        this.idMatchJoueur = idMatchJoueur;
        this.match = match;
        this.joueur = joueur;
        this.tempsJeu = tempsJeu;
    }

    public int getIdMatchJoueur() {
        return idMatchJoueur;
    }

    public void setIdMatchJoueur(int idMatchJoueur) {
        this.idMatchJoueur = idMatchJoueur;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public double getTempsJeu() {
        return tempsJeu;
    }

    public void setTempsJeu(double tempsJeu) {
        this.tempsJeu = tempsJeu;
    }
}
