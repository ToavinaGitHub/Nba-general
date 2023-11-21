package com.nba.nbaws.Entity;

import com.nba.nbaws.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Statistique {

    Joueur joueur;

    double matchJoue;
    double pointParMatch;
    double rebondParMatch;
    double passeDecisiveParMatch;
    double minuteParMatch;
    double efficacite;
    double fg;
    double three;
    double lf;
    double desactive;

    public Statistique() {
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public double getMatchJoue() {
        return matchJoue;
    }

    public void setMatchJoue(int matchJoue) {
        this.matchJoue = matchJoue;
    }

    public double getPointParMatch() {
        return pointParMatch;
    }

    public void setPointParMatch(double pointParMatch) {
        this.pointParMatch = pointParMatch;
    }

    public double getRebondParMatch() {
        return rebondParMatch;
    }

    public void setRebondParMatch(double rebondParMatch) {
        this.rebondParMatch = rebondParMatch;
    }

    public double getPasseDecisiveParMatch() {
        return passeDecisiveParMatch;
    }

    public void setPasseDecisiveParMatch(double passeDecisiveParMatch) {
        this.passeDecisiveParMatch = passeDecisiveParMatch;
    }

    public double getMinuteParMatch() {
        return minuteParMatch;
    }

    public void setMinuteParMatch(double minuteParMatch) {
        this.minuteParMatch = minuteParMatch;
    }

    public double getEfficacite() {
        return efficacite;
    }

    public void setEfficacite(double efficacite) {
        this.efficacite = efficacite;
    }

    public double getFg() {
        return fg;
    }

    public void setFg(double fg) {
        this.fg = fg;
    }

    public double getThree() {
        return three;
    }

    public void setThree(double three) {
        this.three = three;
    }

    public double getLf() {
        return lf;
    }

    public void setLf(double lf) {
        this.lf = lf;
    }

    public double getDesactive() {
        return desactive;
    }

    public void setDesactive(double desactive) {
        this.desactive = desactive;
    }

    public Statistique(Joueur joueur, double matchJoue, double pointParMatch, double rebondParMatch, double passeDecisiveParMatch, double minuteParMatch, double efficacite, double fg, double three, double lf, double desactive) {
        this.joueur = joueur;
        this.matchJoue = matchJoue;
        this.pointParMatch = pointParMatch;
        this.rebondParMatch = rebondParMatch;
        this.passeDecisiveParMatch = passeDecisiveParMatch;
        this.minuteParMatch = minuteParMatch;
        this.efficacite = efficacite;
        this.fg = fg;
        this.three = three;
        this.lf = lf;
        this.desactive = desactive;
    }
}
