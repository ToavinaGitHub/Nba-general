package com.nba.nbaws.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAction;

    String nomAction;

    public Action(int idAction, String nomAction) {
        this.idAction = idAction;
        this.nomAction = nomAction;
    }

    public Action() {
    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public String getNomAction() {
        return nomAction;
    }

    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }
}
