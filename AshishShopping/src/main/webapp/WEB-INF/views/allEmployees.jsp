<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Posts</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body style="text-align:center">
    <form:form method="POST" modelAttribute="Post" action ="AddOrUpdate">

        <label for="userId">User Id:</label>
        <input type="text" name="userId" id="userId"><br>

        <label for="id"> Id:</label>
        <input type="text" name="id" id="id"><br>

        <label for="title">Title:</label>
        <input type="text" name="title" id="title"><br>

        <label for="body">Body:</label>
        <input type="text" name="body" id="body"><br>

       <input type="submit" name"Submit" value="save">
    </form:form>

</body>
</html>
-->