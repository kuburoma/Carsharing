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

import java.util.*;

/**
 * Created by Nell on 15.3.2015.
 */
public class CaseDaoTest {

    StateDao stateDao;
    State state;
    Long stateId;

    @Before
    public void setUp() throws Exception {
        stateDao = new StateDao();

        state = new State();
        state.setName("N1");
        state.setCurrency("CZC");

        Company company = new Company();
        company.setName("N1");
        company.setMotto("M1");
        company.setState(state);


        Department department = new Department();
        department.setName("N1");
        department.setEmail("E1");
        department.setCompany(company);

        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setFirstName("F1");
        user.setLastName("L1");
        user.setDepartment(department);
        users.add(user);
        user = new User();
        user.setFirstName("f2");
        user.setLastName("L2");
        user.setDepartment(department);
        users.add(user);
        user = new User();
        user.setFirstName("F3");
        user.setLastName("L3");
        user.setDepartment(department);
        users.add(user);
        user = new User();
        user.setFirstName("F4");
        user.setLastName("L4");
        user.setDepartment(department);
        users.add(user);
        user = new User();
        user.setFirstName("F5");
        user.setLastName("L5");
        user.setDepartment(department);
        users.add(user);
        user = new User();
        user.setFirstName("F6");
        user.setLastName("L6");
        user.setDepartment(department);
        users.add(user);
        user = new User();
        user.setFirstName("F7");
        user.setLastName("L7");
        user.setDepartment(department);
        users.add(user);
        user = new User();
        user.setFirstName("F8");
        user.setLastName("L8");
        user.setDepartment(department);
        users.add(user);
        user = new User();
        user.setFirstName("F9");
        user.setLastName("L9");
        user.setDepartment(department);
        users.add(user);

        department.setUsers(users);

        List<Department> departments = new ArrayList<Department>();
        departments.add(department);

        company.setDepartments(departments);

        List<Company> companies = new ArrayList<Company>();
        companies.add(company);


        state.setCompanies(companies);

    }


    @Test
    public void userDaoTest() {
        saveState();
        findState();

    }

    public void saveState() {
        stateId = stateDao.create(state);

        state = new State();
        state.setName("Germany");
        state.setCurrency("EUR");
        stateDao.create(state);

        Assert.assertNotNull("Neziskal jsem id uloženého statu", stateId);
    }


    public void findState() {
        UserDao userDao = new UserDao();
        State findState = stateDao.find(stateId);
        List<User> users = userDao.findByState("645");
        List<State> states = stateDao.findByLastName("L1");

        Assert.assertTrue("Nejsou uloženi všichni uživatelé", userDao.findAll().size() != 0);

    }

}
