package com.nba.nbaws.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "terrain")
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTerrain;
    String nomTerrain;
    String localisation;

    public Terrain(int idTerrain, String nomTerrain, String localisation) {
        this.idTerrain = idTerrain;
        this.nomTerrain = nomTerrain;
        this.localisation = localisation;
    }

    public Terrain() {
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public String getNomTerrain() {
        return nomTerrain;
    }

    public void setNomTerrain(String nomTerrain) {
        this.nomTerrain = nomTerrain;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
