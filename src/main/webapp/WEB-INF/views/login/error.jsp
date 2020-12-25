<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 11/26/2020
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Log</title>
    <link rel="icon" type="image/png" href="<c:url value="/resources/login/images/icons/favicon.ico"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/css/main.css"/>">
</head>
<body style="min-height: 100vh;">
    <div style="display: flex;height: 100%; justify-content: center;align-items: center">
        <h2>BẠN KHÔNG ĐƯỢC PHÂN QUYỀN ADMIN</h2>
        <a style="width: 7.5%;margin:0px 10px" href="<c:url value="/direction"/>">Back</a>
    </div>
</body>
</html>
