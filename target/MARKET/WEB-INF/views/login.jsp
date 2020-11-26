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
</head>
<body>
    <%
        int a = (int)request.getAttribute("list");
    %>
    <%=a%>
    <form action="/" method="post">
        <div class="text-logo">
            <img src="<c:url value="/resources/imgs/lg.png"/>" width="60px"/>
            <h2>Sign Up Market Software</h2>
        </div>
        <input type="text" name="username" placeholder="Username"/>
        <input type="password" name="password" placeholder="Password"/>
        <input type="submit" value="login">
        <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
</body>
</html>
