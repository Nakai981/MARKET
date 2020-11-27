<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 11/26/2020
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Page</h1>
<a href="<c:url value="/admin" />">Admin Page</a> <br/>
<form action="<c:url value="/j_spring_security_logout" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
