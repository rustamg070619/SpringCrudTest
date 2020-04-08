<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>USERS</title>
</head>
<body align="center">

<h2>Users</h2>
<hr>
<table align="center">
    <tr>
        <th>id</th>
        <th>login</th>
        <th>password</th>
        <th>roles</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.roles}</td>
            <td>
                <a href="/admin/edit/${user.id}">edit</a>
                <a href="/admin/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/admin/add" var="add"/>
<a href="${add}">Add new user</a>
<h4><a href="<c:url value="/logout"/>">Exit</a></h4>
</body>
</html>
