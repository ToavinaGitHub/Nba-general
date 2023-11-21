package com.nba.nbaws.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "joueur")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idJoueur;

    String nomJoueur;
    Date dtn;
    @ManyToOne
    @JoinColumn(name = "equipe")
    Equipe equipe;

    public Joueur(int idJoueur, String nomJoueur, Date dtn, Equipe equipe) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.dtn = dtn;
        this.equipe = equipe;
    }

    public Joueur() {
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
