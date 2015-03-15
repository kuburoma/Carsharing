package cz.carsharing.servlet;

import cz.carsharing.dao.GenericDaoImpl;
import cz.carsharing.entities.Car;
import cz.carsharing.serializer.Serializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class CarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = new Car();
        car.setName(request.getParameter("name"));
        car.setType(request.getParameter("type"));
        car.setNumberOfDoors(Integer.valueOf(request.getParameter("doors")));

        GenericDaoImpl<Car, Long> carGenericDao = new GenericDaoImpl<Car, Long>(Car.class);
        carGenericDao.create(car);
        response.sendRedirect("/Add.jsp");
    }
}
