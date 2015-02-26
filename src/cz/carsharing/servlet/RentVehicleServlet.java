package cz.carsharing.servlet;

import cz.carsharing.entities.RentVehicle;
import cz.carsharing.serializer.Serializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class RentVehicleServlet extends HttpServlet {

    Serializer<RentVehicle,String> serializer = new Serializer<RentVehicle, String>("RentVehicle");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RentVehicle rentVehicle = new RentVehicle();
        rentVehicle.setUser(request.getParameter("user"));
        rentVehicle.setVehicle(request.getParameter("vehicle"));
        rentVehicle.setId(UUID.randomUUID().toString());
        serializer.create(rentVehicle);

        response.sendRedirect("/rentvehicle.jsp");
    }
}
