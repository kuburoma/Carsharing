<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cz.carsharing.serializer.Serializer" %>
<%@ page import="cz.carsharing.utilities.ServerConstants" %>
<%@ page import="cz.carsharing.entities.*" %>
<%@ page import="cz.carsharing.dao.GenericDaoImpl" %>
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
    <form action="car" method="post">
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="type"></td>
            <td><input type="text" name="doors"/></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </form>
</table>

<br>

<table frame="hsides">
    <tr>

        <%
            GenericDaoImpl<Car, Long> carGenericDao = new GenericDaoImpl<Car, Long>(Car.class);
            List<Car> cars = new ArrayList<Car>();
            cars.addAll(carGenericDao.findAll());

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
                        for (Car car : cars) {
                    %>
                    <%= car.toString()%> <br>
                    <%
                        }
                    %>

                </td>
            </tr>
        </table>

    </tr>
</table>


</table>

</body>
</html>
