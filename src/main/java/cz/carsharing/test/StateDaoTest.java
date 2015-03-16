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
    UserDao userDao;
    Long stateId;
    Long userId;

    State state;
    Company company;
    Department department;
    User user;



    @Before
    public void setUp() throws Exception {
        stateDao = new StateDao();
        userDao = new UserDao();

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
        saveState();
        findState();
        findStateByName();
        deleteState();
    }

    public void saveUser() {
        userId = userDao.create(user);

        Assert.assertNotNull("Neziskal jsem id uloženého statu", userId);
    }

    public void findUser() {
        User findUser = userDao.find(userId);

        Assert.assertEquals("First name se neschoduje", user.getFirstName(), findUser.getFirstName());
        Assert.assertEquals("last name se neschoduje", user.getLastName(), findUser.getLastName());
    }

    public void saveState() {
        stateId = stateDao.create(state);

        Assert.assertNotNull("Neziskal jsem id uloženého statu", stateId);
    }


    public void findState() {
        State findState = stateDao.find(stateId);

        Assert.assertEquals("First name se neschoduje", user.getFirstName(), findState.getCompanies().get(0).getDepartments().get(0).getUsers().get(0).getFirstName());
        Assert.assertEquals("last name se neschoduje", user.getLastName(), findState.getCompanies().get(0).getDepartments().get(0).getUsers().get(0).getLastName());
    }

    public void findStateByName(){
        List<State> findStates = stateDao.findByName("Česká republika");
        Assert.assertNotNull("Státy jsou Null", findStates);
        Assert.assertTrue("Nenašel jsem Žádné státy", findStates.size() != 0);
    }

    public void deleteState(){
        stateDao.delete(stateId);

        State findState = stateDao.find(stateId);
        User findUser = userDao.find(userId);

        Assert.assertNull("State je stále v databázi", findState);
        Assert.assertNull("Uživatel je stále v databázi", findUser);
    }

}
