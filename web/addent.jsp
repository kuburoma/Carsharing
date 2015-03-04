<%@ page import="cz.carsharing.entities.Vehicle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cz.carsharing.entities.Car" %>
<%@ page import="cz.carsharing.entities.Truck" %>
<%@ page import="cz.carsharing.entities.User" %>
<%@ page import="cz.carsharing.serializer.Serializer" %>
<%@ page import="cz.carsharing.utilities.ServerConstants" %>
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
    <title>Cars</title>
</head>
<body>

<table frame="hsides">
    <tr>
        <td>Auto</td>
    </tr>
    <tr>
        <td>Jméno</td>
        <td>Typ</td>
    </tr>
    <form action="car" method="post">
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="type"></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </form>
</table>

<br>

<table frame="hsides">
    <tr>
        <td>Truck</td>
    </tr>
    <tr>
        <td>Jméno</td>
        <td>Typ</td>
        <td>Počet kol</td>
    </tr>
    <form action="truck" method="post">
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="type"></td>
            <td><input type="text" name="numberOfWheels"></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </form>
</table>

<br>

<table frame="hsides">
    <tr>
        <td>Uživatel</td>
    </tr>
    <tr>
        <td>Jméno</td>
        <td>Příjmení</td>
    </tr>
    <form action="user" method="post">
        <tr>
            <td><input type="text" name="firstName"></td>
            <td><input type="text" name="lastName"></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </form>
</table>
<table frame="hsides">
    <tr>
        <td>Uživatel jsi půjčí auto</td>
    </tr>
    <tr>
        <td>Uživatel</td>
        <td>Auto</td>
    </tr>
    <form action="user" method="post">
        <tr>

            <%
                Serializer<Vehicle,String> vehicleSerializer = new Serializer<Vehicle,String>(ServerConstants.vehicleDatabase);
                Serializer<User,String> userSerializer = new Serializer<User,String>(ServerConstants.userDatabase);
                List<Vehicle> vehicles = new ArrayList<Vehicle>();
                List<User> users = new ArrayList<User>();
                vehicles.addAll(vehicleSerializer.findAll());
                users.addAll(userSerializer.findAll());
            %>

            <table>
                <tr>
                    <td>
                        Vozidla
                    </td>
                    <td>
                        Uživatel
                    </td>
                </tr>
                <tr>
                    <td>

                        <%
                            for(Vehicle vehicle : vehicles){
                        %>
                        <%= vehicle.toString()%> <br>
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

            <td><input type="text" name="firstName"></td>
            <td><input type="text" name="lastName"></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </form>
</table>


</table>

</body>
</html>
