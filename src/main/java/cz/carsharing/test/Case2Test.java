package cz.carsharing.test;

import cz.carsharing.dao.*;
import cz.carsharing.entities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nell on 15.3.2015.
 */
public class Case2Test {

    StateDao stateDao;
    CompanyDao companyDao;
    DepartmentDao departmentDao;
    UserDao userDao;
    CarDao carDao;

    Long stateId;
    Long companyId;
    Long departmentId;
    Long userId;
    Long carId;

    State state1;
    State state2;

    Company company1;
    Company company2;
    Company company3;

    Department department1;
    Department department2;
    Department department3;
    Department department4;

    User user1;
    User user2;
    User user3;
    User user4;
    User user5;
    User user6;
    User user7;
    User user8;
    User user9;

    Car car1;
    Car car2;




    @Before
    public void setUp() throws Exception {
        stateDao = new StateDao();
        companyDao = new CompanyDao();
        departmentDao = new DepartmentDao();
        userDao = new UserDao();
        carDao = new CarDao();

        state1 = new State();
        state1.setName("SN1");
        state1.setCurrency("SC1");

        state2 = new State();
        state2.setName("SN2");
        state2.setCurrency("SC2");

        company1 = new Company();
        company1.setName("CN1");
        company1.setMotto("CM1");

        company2 = new Company();
        company2.setName("CN2");
        company2.setMotto("CM2");

        company3 = new Company();
        company3.setName("CN3");
        company3.setMotto("CM3");


        department1 = new Department();
        department1.setName("DN1");
        department1.setEmail("DE1");

        department2 = new Department();
        department2.setName("DN2");
        department2.setEmail("DE2");

        department3 = new Department();
        department3.setName("DN3");
        department3.setEmail("DE3");

        department4 = new Department();
        department4.setName("DN4");
        department4.setEmail("DE4");


        user1 = new User();
        user1.setFirstName("UF1");
        user1.setLastName("UL1");

        user2 = new User();
        user2.setFirstName("UF2");
        user2.setLastName("UL2");

        user3 = new User();
        user3.setFirstName("UF3");
        user3.setLastName("UL3");

        user4 = new User();
        user4.setFirstName("UF4");
        user4.setLastName("UL4");

        user5 = new User();
        user5.setFirstName("UF5");
        user5.setLastName("UL5");

        user6 = new User();
        user6.setFirstName("UF6");
        user6.setLastName("UL6");

        user7 = new User();
        user7.setFirstName("UF7");
        user7.setLastName("UL7");

        user8 = new User();
        user8.setFirstName("UF8");
        user8.setLastName("UL8");

        user9 = new User();
        user9.setFirstName("UF9");
        user9.setLastName("UL9");

        car1 = new Car();
        car1.setName("CN1");
        car1.setType("CT1");
        car1.setNumberOfDoors(1);


        car2 = new Car();
        car2.setName("CN2");
        car2.setType("CT2");
        car2.setNumberOfDoors(2);


    }


    @Test
    public void userDaoTest() {
        saveEntities();
        stateId = saveState();

        State state = stateDao.find(stateId);

        Assert.assertNotNull("Auta se neuložila", state.getCompanies().get(0).getDepartments().get(0).getUsers().get(0).getRentVehicles().size() == 2);

        System.out.println("***** Before update ******");

        List<State> states = new ArrayList<State>();
        states.add(state);
        stateToString(states);

        System.out.println("***** After update ******");

        updateState(state);

        stateToString(stateDao.findByName("SN1"));

    }

    public void saveEntities(){
        carId = carDao.create(car2);
        Assert.assertNotNull("Nepodařilo se uložit car2", carId);

        userId = userDao.create(user2);
        Assert.assertNotNull("Nepodařilo se uložit user2", userId);

        departmentId = departmentDao.create(department2);
        Assert.assertNotNull("Nepodařilo se uloži departmet2", departmentId);

        companyId = companyDao.create(company2);
        Assert.assertNotNull("Nepodařilo se uložit company2", companyId);
    }


    public Long saveState(){
        Car car = carDao.find(carId);
        Assert.assertNotNull("Nepodařilo se získat car2", car);

        User user = userDao.find(userId);
        Assert.assertNotNull("Nepodařilo se získat user2", user);

        Department department = departmentDao.find(departmentId);
        Assert.assertNotNull("Nepodařilo se získat department2", department);

        Company company = companyDao.find(companyId);
        Assert.assertNotNull("Nepodařilo se získat company2", company);

        user1.addRentVehicle(car1);
        car1.addUser(user1);
        user1.addRentVehicle(car);
        car.addUser(user1);

        user1.setDepartment(department1);
        department1.addUser(user1);
        user.setDepartment(department1);
        department1.addUser(user);

        department1.setCompany(company1);
        company1.addDepartment(department1);
        department.setCompany(company1);
        company1.addDepartment(department);

        company1.setState(state1);
        state1.addCompany(company1);
        company.setState(state1);
        state1.addCompany(company);

        return stateDao.create(state1);
    }

    public void updateState(State state){
        Company company1 = state.getCompanies().get(0);
        Company company2 = state.getCompanies().get(1);
        Department department1 = company1.getDepartments().get(0);
        Department department2 = company1.getDepartments().get(1);
        User user1 = department1.getUsers().get(0);
        User user2 = department1.getUsers().get(1);

        company1.setDepartments(null);
        company1.setState(null);
        state.setCompanies(null);
        state.addCompany(company2);

        company2.setState(state);
        company2.addDepartment(department2);

        department1.setCompany(null);
        department1.setUsers(null);

        department2.setCompany(company2);
        department2.setUsers(null);
        department2.addUser(user2);

        user2.setDepartment(department2);

        user1.setDepartment(null);

        user2.setFirstName("UF2TEST");
        department2.setName("DN2TEST");
        company2.setName("CN2TEST");

        stateDao.update(state);
    }

    public void stateToString(List<State> states){
        Iterator<State> its = states.iterator();
        while(its.hasNext()){
            State s = its.next();
            System.out.println(s.toString());
            Iterator<Company> itc = s.getCompanies().iterator();
            if(s.getCompanies() == null){
                break;
            }
            while(itc.hasNext()){
                Company c = itc.next();
                System.out.println(c.toString());
                if(c.getDepartments() == null){
                    break;
                }
                Iterator<Department> itd = c.getDepartments().iterator();
                while(itd.hasNext()){
                    Department d = itd.next();
                    System.out.println(d.toString());
                    if(d.getUsers() == null){
                        break;
                    }
                    Iterator<User> itu = d.getUsers().iterator();
                    while(itu.hasNext()){
                        User u = itu.next();
                        System.out.println(u.toString());
                        if(u.getRentVehicles() == null){
                            break;
                        }
                        Iterator<Vehicle> itv = u.getRentVehicles().iterator();
                        while(itv.hasNext()){
                            Vehicle v = itv.next();
                            System.out.println(v.toString());
                        }
                    }
                }
            }
        }
    }

}
