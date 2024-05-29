<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 29/05/2024
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<form action="/BookManagement?action=update" method="post">
    <div class="mb-3 mx-3 my-3">
        <lable>ID:</lable>
        <input class="form-control" type="text" name="bookId" readonly value="${book.bookId}"/>
    </div>
    <div class="mb-3 mx-3 my-3">
        <lable>Name:</lable>
        <input class="form-control" type="text" name="bookName" value="${book.bookName}"/>
    </div>
    <div class="mb-3 mx-3 my-3">
        <lable>Price:</lable>
        <input class="form-control" type="number" name="price" value="${book.price}"/>
    </div>
    <div class="mb-3 mx-3 my-3">
        <lable>Description:</lable>
        <input class="form-control" type="text" name="description" value="${book.description}"/>
    </div>
    <div class="mb-3 mx-3 my-3">
        <lable>Auth:</lable>
        <input class="form-control" type="text" name="auth" value="${book.auth}"/>
    </div>
    <button  class="btn btn-outline-primary btn-lg mx-3" type="submit">Update</button>
</form>
</body>
</html>
