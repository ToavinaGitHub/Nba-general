package com.nba.nbaws.repository;

import com.nba.nbaws.Entity.Action;
import org.springframework.data.repository.CrudRepository;

public interface ActionRepository extends CrudRepository<Action,Integer> {

    public Action findByIdAction(int idAction);
}
