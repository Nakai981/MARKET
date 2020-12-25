<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 11/28/2020
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Điều hướng</title>
    <link rel="icon" type="image/png" href="<c:url value="/resources/login/images/icons/favicon.ico"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/css/main.css"/>">
</head>
<body style="min-height: 100vh;">
    <div style="display: flex;height: 100%; justify-content: center;align-items: center">
        <a style="width: 7.5%;margin:0px 10px"class="login100-form-btn" href="<c:url value="/admin"/>">Admin</a>
        <a   style="width: 7.5%;margin:0px 10px" class="login100-form-btn" href="<c:url value="/user"/>">User</a>
        <form class="logout" action="<c:url value="/j_spring_security_logout" />" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input class="login100-form-btn" type="submit" value="Logout"/>
        </form>
    </div>
</body>
</html>
