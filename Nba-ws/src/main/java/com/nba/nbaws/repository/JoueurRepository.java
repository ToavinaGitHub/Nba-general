package com.nba.nbaws.repository;

import com.nba.nbaws.Entity.ActionMatchJoueur;
import com.nba.nbaws.Entity.Equipe;
import com.nba.nbaws.Entity.Joueur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Vector;

public interface JoueurRepository extends CrudRepository<Joueur,Integer> {

    public Joueur findByIdJoueur(int id);

    public List<Joueur> findJoueurByEquipe(Equipe equipe);


    @Query("SELECT count(m) FROM MatchJoueur m WHERE m.tempsJeu>0 and m.joueur=?1")
    public int matchJoue(Joueur j);


    @Query("SELECT CAST(SUM(amj.etat) / :totalMatch AS double) FROM ActionMatchJoueur amj WHERE amj.action.idAction = 2 AND amj.joueur.idJoueur = :joueurId AND amj.etat > 0")
    public double pointMoyenneParMatch(@Param("joueurId") int joueurId, @Param("totalMatch") int totalMatch);

    @Query("SELECT CAST(COUNT(amj) / :totalMatch AS double) FROM ActionMatchJoueur amj WHERE amj.action.idAction = 3 AND amj.joueur.idJoueur = :joueurId AND amj.etat > 0")
    public double rebondMoyenneParMatch(@Param("joueurId") int joueurId, @Param("totalMatch") int totalMatch);

    @Query("SELECT CAST(COUNT(amj) / :totalMatch AS double) FROM ActionMatchJoueur amj WHERE amj.action.idAction = 1 AND amj.joueur.idJoueur = :joueurId AND amj.etat = 5")
    public double passeDecisive(@Param("joueurId") int joueurId, @Param("totalMatch") int totalMatch);


    @Query("SELECT count(m) FROM ActionMatchJoueur m where (m.action.idAction=2 or m.action.idAction=5) and m.etat>0 and m.joueur.idJoueur= :joueur")
    public int totalTirMaty(@Param("joueur") int joueur);

    @Query("SELECT (CAST(count(m) AS double) / CASE WHEN :tirMaty = 0 THEN 1 ELSE :tirMaty END) * 100 FROM ActionMatchJoueur m WHERE m.action.idAction = 2 AND m.etat = 3 AND m.joueur.idJoueur = :idJoueur")
    public double three(@Param("idJoueur") int idJoueur, @Param("tirMaty") int tirMaty);

    @Query("SELECT (CAST(count(m) AS double) / CASE WHEN :tirMaty = 0 THEN 1 ELSE :tirMaty END) * 100 FROM ActionMatchJoueur m WHERE m.action.idAction = 5 AND m.etat > 0 AND m.joueur.idJoueur = :idJoueur")
    public double lf(@Param("idJoueur") int idJoueur, @Param("tirMaty") int tirMaty);

    @Query("SELECT j FROM Joueur j WHERE j.equipe.idEquipe= :idEquipe")
    public List<Joueur> joueurEquipe(@Param("idEquipe")int idEquipe);

    @Query("SELECT (CAST(sum(m.tempsJeu) as double )) / :match FROM MatchJoueur m where m.joueur.idJoueur = :joueur")
    public double getMinuteMatch(@Param("joueur") int idJoueur,@Param("match") int nbMatch);


    @Query("SELECT a FROM ActionMatchJoueur a WHERE (a.action.idAction=2 or a.action.idAction=5) and a.joueur.idJoueur= :joueur")
    public Vector<ActionMatchJoueur> getAllTir(@Param("joueur")int joueur);

}
