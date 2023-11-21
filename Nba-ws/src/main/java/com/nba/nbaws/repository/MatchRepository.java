package com.nba.nbaws.repository;

import com.nba.nbaws.Entity.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match,Integer> {

    public Match findByIdMatch(int id);


}
