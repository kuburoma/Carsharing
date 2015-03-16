package cz.carsharing.dao;

import cz.carsharing.entities.Department;

public class DepartmentDao extends GenericDaoImpl<Department,Long> {

    public DepartmentDao(){
        super(Department.class);
    }



}
