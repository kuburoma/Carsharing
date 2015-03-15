package cz.carsharing.servlet;

import cz.carsharing.entities.Car;
import cz.carsharing.entities.Truck;
import cz.carsharing.serializer.Serializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class TruckServlet extends HttpServlet {

    //Serializer<Truck,String> serializer = new Serializer<Truck, String>("Vehicle");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  Truck truck = new Truck();
        truck.setName(request.getParameter("name"));
        truck.setType(request.getParameter("type"));
        truck.setNumberOfWheels(Integer.valueOf(request.getParameter("numberOfWheels")));
        truck.setId(UUID.randomUUID().toString());
        serializer.create(truck);

        response.sendRedirect("/show.jsp");*/
    }
}
