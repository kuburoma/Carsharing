package cz.carsharing.dao;

import cz.carsharing.entities.State;

public class StateDao extends GenericDaoImpl<State,Long> {

    public StateDao(){
        super(State.class);
    }



}
