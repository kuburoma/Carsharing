package cz.carsharing.test;

import cz.carsharing.dao.CarDao;
import cz.carsharing.entities.Car;
import cz.carsharing.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarDaoTest {

    CarDao carDao;
    Long carId;
    Car car;


    @Before
    public void setUp() throws Exception {
        carDao = new CarDao();
        car = new Car();
        car.setType("SUV");
        car.setName("Ford");
        car.setNumberOfDoors(8);
    }


    @Test
    public void carDaoTest() {
        saveCar();
        //findCar();
        //deleteCar();
    }

    public void saveCar() {
        carId = carDao.create(car);

        Assert.assertNotNull("Neziskal jsem id uloženého auta", carId);
    }


    public void findCar() {
        Car findCar = carDao.find(carId);

        Assert.assertEquals("Typ auta se neschoduje", car.getType(), findCar.getType());
        Assert.assertEquals("Jméno auta se neschoduje", car.getName(), findCar.getName());
        Assert.assertEquals("Počet dveří se neschoduje", car.getNumberOfDoors(), findCar.getNumberOfDoors());
    }


    public void deleteCar() {
        carDao.delete(carId);
        Car findCar = carDao.find(carId);

        Assert.assertNull("Auto je stále v databázi", findCar);
    }

}