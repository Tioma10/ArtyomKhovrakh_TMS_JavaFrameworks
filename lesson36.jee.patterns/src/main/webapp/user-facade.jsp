<%@ page import="facade.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<h2>Session Facade Example</h2>
<p>Name: <%= user.getName() %></p>
<p>Age: <%= user.getAge() %></p>
