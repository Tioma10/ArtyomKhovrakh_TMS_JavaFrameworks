<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Application Form</title>
</head>
<body>
<h2>Fill out the application form</h2>
<form action="save-request" method="post">
    <label for="name">Name:</label><br>
    <input type="text" name="name" id="name"><br><br>

    <label for="email">Email:</label><br>
    <input type="email" name="email" id="email"><br><br>

    <label for="requestText">Message:</label><br>
    <textarea name="requestText" id="requestText"></textarea><br><br>

    <button type="submit">Submit</button>
</form>
</body>
</html>
