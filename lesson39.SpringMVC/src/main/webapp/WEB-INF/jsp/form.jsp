<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Car Form</title></head>
<body>
<h2>Car Form</h2>
<form:form method="post" modelAttribute="car" action="${pageContext.request.contextPath}/cars">
    <form:hidden path="id"/>
    Model: <form:input path="model"/><br/>
    Brand: <form:input path="brand"/><br/>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>