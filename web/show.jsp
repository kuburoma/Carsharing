<%@ page import="cz.carsharing.serializer.Serializer" %>
<%@ page import="cz.carsharing.entities.Car" %>
<%@ page import="cz.carsharing.entities.Truck" %>
<%@ page import="cz.carsharing.entities.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Nell-NTB
  Date: 25.2.2015
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>

<%
    Serializer<Car,String> carSerializer = new Serializer<Car,String>(Car.class);
    Serializer<Truck,String> truckSerializer = new Serializer<Truck,String>(Truck.class);
    Serializer<User,String> userSerializer = new Serializer<User,String>(User.class);
    List<Car> cars = carSerializer.findAll();
    List<Truck> trucks = truckSerializer.findAll();
    List<User> users = userSerializer.findAll();
%>

<table>
    <tr>
        <td>
            Auta
        </td>
        <td>
            Náklaďáky
        </td>
        <td>
            Uživatel
        </td>
    </tr>
    <tr>
        <td>

            <%
                for(Car car : cars){
            %>
            <%= vehicle.toString()%> <br>
            <%
                }
            %>

        </td>
        <td>
            <%
                for(Truck truck : trucks){
            %>
            <%= truck.toString()%> <br>
            <%
                }
            %>
        </td>
        <td>
            <%
                for(User user : users){
            %>
            <%= user.toString()%> <br>
            <%
                }
            %>
        </td>
    </tr>
</table>


</body>
</html>
