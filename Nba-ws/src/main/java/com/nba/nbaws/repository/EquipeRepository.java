package com.nba.nbaws.repository;

import com.nba.nbaws.Entity.Equipe;
import com.nba.nbaws.Entity.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipeRepository extends CrudRepository<Equipe,Integer> {

    public Equipe findByIdEquipe(int idEquipe);


    @Query("SELECT m FROM Match m WHERE m.equipe1 = ?1 or m.equipe2=?1")
    public List<Match> matchJoue(Equipe idEq);
}
