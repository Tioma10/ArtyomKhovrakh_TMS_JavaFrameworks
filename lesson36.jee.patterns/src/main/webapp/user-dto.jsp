<%@ page import="dto.UserDTO" %>
<%
    UserDTO user = (UserDTO) request.getAttribute("user");
%>
<h2>Data Transfer Object Example</h2>
<p>Name: <%= user.getName() %></p>
<p>Email: <%= user.getEmail() %></p>
<p>Age: <%= user.getAge() %></p>