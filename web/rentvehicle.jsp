<%@ page import="cz.carsharing.serializer.Serializer" %>
<%@ page import="cz.carsharing.entities.Vehicle" %>
<%@ page import="cz.carsharing.entities.User" %>
<%@ page import="java.util.List" %>
<%@ page import="cz.carsharing.entities.RentVehicle" %>
<%@ page import="cz.carsharing.utilities.ServerConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<%
    Serializer<Vehicle, String> vehicleSerializer = new Serializer<Vehicle, String>(ServerConstants.vehicleDatabase);
    Serializer<User, String> userSerializer = new Serializer<User, String>(ServerConstants.userDatabase);
    List<Vehicle> vehicles = vehicleSerializer.findAll();
    List<User> users = userSerializer.findAll();
    Serializer<RentVehicle, String> rentVehicleSerializer = new Serializer<RentVehicle, String>(ServerConstants.rentVehicleDatabase);
    List<RentVehicle> rentVehicles = rentVehicleSerializer.findAll();
%>

<table>
    <tr>
        <td>
            Vehicle
        </td>
        <td>
            Uživatel
        </td>
    </tr>
    <tr>
        <form action="rentVehicle" method="post">
            <td>

                <select name="vehicle">
                    <%
                        for (Vehicle vehicle : vehicles) {
                    %>

                    <option value="<%= vehicle.getId() %>"><%= vehicle.toString()%>
                    </option>

                    <%
                        }
                    %>
                </select>
            </td>
            <td>
                <select name="user">
                    <%
                        for (User user : users) {
                    %>

                    <option value="<%= user.getId() %>"><%= user.toString()%>
                    </option>

                    <%
                        }
                    %>
                </select>
            </td>
            <input type="submit" value="Submit">
        </form>
    </tr>

    <%
        for (RentVehicle rentVehicle : rentVehicles) {
    %>
    <tr>

        <td>
            <%= userSerializer.find(rentVehicle.getUser()).toString() %>
        </td>
        <td>
            <%= vehicleSerializer.find(rentVehicle.getVehicle()).toString() %>
        </td>
    </tr>
    <%
        }
    %>

</table>


</body>
</html>
