package com.nba.nbaws.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMatch;
    Date dateDebut;
    Date dateFin;

    @ManyToOne
    @JoinColumn(name = "equipe1")
    Equipe equipe1;
    @ManyToOne
    @JoinColumn(name = "equipe2")
    Equipe equipe2;

    @ManyToOne
    @JoinColumn(name = "terrain")
    Terrain terrain;

    int score1;
    int score2;
    int etat;

    public Match(int idMatch, Date dateDebut, Date dateFin, Equipe equipe1, Equipe equipe2, Terrain terrain, int score1, int score2, int etat) {
        this.idMatch = idMatch;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.terrain = terrain;
        this.score1 = score1;
        this.score2 = score2;
        this.etat = etat;
    }

    public Match() {
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
