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
    <link rel="icon" href="<c:url value="/resources/imgs/lg.png"/>" type="image/gif" sizes="16x16">
    <title>Directional</title>
</head>
<body>
    <a href="<c:url value="/admin"/>">Admin</a>
    <a href="<c:url value="/user"/>">User</a>
    <form action="<c:url value="/j_spring_security_logout" />" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout"/>
    </form>
</body>
</html>