<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 11/26/2020
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Mini Supermarket </title>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="<c:url value="/resources/anime-page/assets/AT-pro-logo.png"/>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/user/css/all.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/user/1.css"/>">
    <script src="https://unpkg.com/sweetalert2@7.8.2/dist/sweetalert2.all.js"></script>
</head>
<body>
<div class="banner">

</div>


<tiles:insertAttribute name="body"/>
</body>
</html>
