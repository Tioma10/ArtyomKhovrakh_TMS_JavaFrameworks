<!DOCTYPE html>
<html>
<head><title>Car List</title></head>
<body>
<h2>Car List</h2>

<a href="/cars/new">Add New Car</a>

<#if cars?size gt 0>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Model</th>
            <th>Brand</th>
            <th>Actions</th>
        </tr>
        <#list cars as car>
            <tr>
                <td>${car.id}</td>
                <td>${car.model}</td>
                <td>${car.brand}</td>
                <td>
                    <a href="/cars/edit?id=${car.id}">Edit</a>
                    <a href="/cars/delete?id=${car.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
<#else>
    <p>No cars available</p>
</#if>

</body>
</html>