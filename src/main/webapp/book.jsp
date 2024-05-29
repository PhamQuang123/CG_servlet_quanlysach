<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 29/05/2024
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Book</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<a href="BookManagement?action=initCreate">
    <button  class="btn btn-outline-primary btn-lg mt-4 mx-4">Add New book</button>
</a>
<br>
<br>
<table class="table table-hover ms-3 me-4">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Auth</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBooks}" var="Book">
        <tr>
            <td>${Book.bookId}</td>
            <td>${Book.bookName}</td>
            <td>${Book.price}</td>
            <td>${Book.description}</td>
            <td>${Book.auth}</td>
            <td><a href="/BookManagement?action=edit&id=${Book.bookId}">
                <button class="btn btn-outline-warning">Edit</button>
            </a></td>
            <td>
                <a href="/BookManagement?action=delete&id=${Book.bookId}">
                    <button class="btn btn-outline-danger">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
