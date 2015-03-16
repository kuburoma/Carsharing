package cz.carsharing.test;

import cz.carsharing.dao.StateDao;
import cz.carsharing.dao.UserDao;
import cz.carsharing.entities.Company;
import cz.carsharing.entities.Department;
import cz.carsharing.entities.State;
import cz.carsharing.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nell on 15.3.2015.
 */
public class StateDaoTest {
    StateDao stateDao;
    Long stateId;

    State state;
    Company company;
    Department department;
    User user;



    @Before
    public void setUp() throws Exception {
        stateDao = new StateDao();

        user = new User();
        user.setFirstName("Pepa");
        user.setLastName("Novák");
        List<User> users = new ArrayList<User>();
        users.add(user);

        department = new Department();
        department.setName("IT");
        department.setEmail("it@cz.cz");
        department.setUsers(users);
        List<Department> departments = new ArrayList<Department>();
        departments.add(department);

        company = new Company();
        company.setName("CVUT");
        company.setMotto("Hell on Fell");
        company.setDepartments(departments);
        List<Company> companies = new ArrayList<Company>();
        companies.add(company);

        state = new State();
        state.setName("Česká republika");
        state.setCurrency("CZC");
        state.setCompanies(companies);

    }


    @Test
    public void userDaoTest() {
        saveUser();
        findUser();
        //deleteUser();
    }

    public void saveUser() {
        stateId = stateDao.create(state);

        Assert.assertNotNull("Neziskal jsem id uloženého statu", stateId);
    }


    public void findUser() {
        State findState = stateDao.find(stateId);

        Assert.assertEquals("First name se neschoduje", user.getFirstName(), findState.getCompanies().get(0).getDepartments().get(0).getUsers().get(0).getFirstName());
        Assert.assertEquals("last name se neschoduje", user.getLastName(), findState.getCompanies().get(0).getDepartments().get(0).getUsers().get(0).getLastName());
    }


   /* public void deleteUser() {
        userDao.delete(userId);
        User findUser = userDao.find(userId);

        Assert.assertNull("Uživatel je stále v databázi", findUser);
    }*/

}
