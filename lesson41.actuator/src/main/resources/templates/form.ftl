<!DOCTYPE html>
<html>
<head>
    <title>Car Form</title>
</head>
<body>
<h2>Car Form</h2>

<form action="/cars" method="post">
    <input type="hidden" name="id" value="${car.id!0}" />

    Model: <input type="text" name="model" value="${car.model!}" />
    <#if errors?? && errors["model"]??>
        <div style="color:red">${errors["model"]}</div>
    </#if>
    <br/>

    Brand: <input type="text" name="brand" value="${car.brand!}" />
    <#if errors?? && errors["brand"]??>
        <div style="color:red">${errors["brand"]}</div>
    </#if>
    <br/>

    <input type="submit" value="Save"/>
</form>

</body>
</html>
