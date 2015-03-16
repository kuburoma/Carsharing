package cz.carsharing.dao;

import cz.carsharing.entities.Car;
import cz.carsharing.entities.Company;

public class CompanyDao extends GenericDaoImpl<CompanyDao,Long> {

    public CompanyDao(){
        super(Company.class);
    }



}
