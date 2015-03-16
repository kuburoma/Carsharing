package cz.carsharing.test;

import cz.carsharing.dao.CarDao;
import cz.carsharing.dao.UserDao;
import cz.carsharing.entities.Car;
import cz.carsharing.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nell on 15.3.2015.
 */
public class UserDaoTest {
    UserDao userDao;
    Long userId;
    User user;


    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
        user = new User();
        user.setFirstName("Pepa");
        user.setLastName("Novák");
    }


    @Test
    public void userDaoTest() {
        saveUser();
        findUser();
        deleteUser();
    }

    public void saveUser() {
        userId = userDao.create(user);

        Assert.assertNotNull("Neziskal jsem id uloženého auta", userId);
    }


    public void findUser() {
        User findUser = userDao.find(userId);

        Assert.assertEquals("First name se neschoduje", user.getFirstName(), findUser.getFirstName());
        Assert.assertEquals("last name se neschoduje", user.getLastName(), findUser.getLastName());
    }


    public void deleteUser() {
        userDao.delete(userId);
        User findUser = userDao.find(userId);

        Assert.assertNull("Uživatel je stále v databázi", findUser);
    }

}
