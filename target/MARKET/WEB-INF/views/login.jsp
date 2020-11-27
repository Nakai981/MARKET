<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 11/26/2020
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Market</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="icon" href="<c:url value="/resources/imgs/lg.png"/>" type="image/gif" sizes="16x16">
</head>
<body>
    <h3>${list}</h3>
    <form name='loginForm' action="<c:url value='/j_spring_security_login' />" method="post">
        <div class="text-logo">
            <img src="<c:url value="/resources/imgs/lg.png"/>" width="60px"/>
            <h2>Sign Up Market Software</h2>
        </div>
        <input type="text" name="username" placeholder="Username"/>
        <input type="password" name="password" placeholder="Password"/>
        <input type="submit" name="submit"value="login">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <p class="message">Not registered? <a href="#">Create an account</a></p>
        <p class="danger">${message}</p>
    </form>

</body>
</html>
