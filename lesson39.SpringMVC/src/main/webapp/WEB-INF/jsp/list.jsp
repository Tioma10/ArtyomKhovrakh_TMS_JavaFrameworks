<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List, com.example.model.Car" %>
<html>
<head><title>Car List</title></head>
<body>
<h2>Car List</h2>

<a href="${pageContext.request.contextPath}/cars/new">Add New Car</a>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Model</th>
    <th>Brand</th>
    <th>Actions</th>
  </tr>

  <%
    List<Car> cars = (List<Car>) request.getAttribute("cars");
    if (cars != null && !cars.isEmpty()) {
      for (Car car : cars) {
  %>
  <tr>
    <td><%= car.getId() %></td>
    <td><%= car.getModel() %></td>
    <td><%= car.getBrand() %></td>
    <td>
      <a href="<%= request.getContextPath() %>/cars/edit?id=<%= car.getId() %>">Edit</a>
      <a href="<%= request.getContextPath() %>/cars/delete?id=<%= car.getId() %>">Delete</a>
    </td>
  </tr>
  <%
    }
  } else {
  %>
  <tr><td colspan="4">No cars available</td></tr>
  <%
    }
  %>
</table>
</body>
</html>