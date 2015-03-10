package cz.carsharing.servlet;

import cz.carsharing.dao.GenericDaoImpl;
import cz.carsharing.entities.Car;
import cz.carsharing.entities.Carr;
import cz.carsharing.serializer.Serializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class CarServlet extends HttpServlet {

    Serializer<Car,String> serializer = new Serializer<Car, String>("Vehicle");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Carr car = new Carr();
        car.setName(request.getParameter("name"));
        car.setType(request.getParameter("type"));
        System.out.println("ahoj");

        GenericDaoImpl<Carr, Long> carrGenericDao = new GenericDaoImpl<Carr, Long>();
        carrGenericDao.create(car);
    }
}
