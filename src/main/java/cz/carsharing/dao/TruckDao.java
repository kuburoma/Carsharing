package cz.carsharing.dao;

import cz.carsharing.entities.Truck;

/**
 * Created by Nell-NTB on 12.3.2015.
 */
public class TruckDao extends GenericDaoImpl<Truck,Long> {

    public TruckDao(){
        super(Truck.class);
    }
}
