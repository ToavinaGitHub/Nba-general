package com.nba.nbaws.Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idEquipe;

    String nomEquipe;
    String abbreviation;


    public Equipe(int idEquipe, String nomEquipe, String abbreviation) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.abbreviation = abbreviation;
    }

    public Equipe() {
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
