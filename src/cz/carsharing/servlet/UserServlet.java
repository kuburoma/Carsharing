package cz.carsharing.servlet;

import cz.carsharing.entities.Car;
import cz.carsharing.entities.User;
import cz.carsharing.serializer.Serializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class UserServlet extends HttpServlet {

    Serializer<User,String> serializer = new Serializer<User, String>("User");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setId(UUID.randomUUID().toString());
        serializer.create(user);

        response.sendRedirect("/show.jsp");
    }
}
