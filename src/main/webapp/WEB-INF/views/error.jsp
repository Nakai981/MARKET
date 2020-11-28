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
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="icon" href="<c:url value="/resources/imgs/lg.png"/>" type="image/gif" sizes="16x16">
</head>
<body>
    <div class="ad-ur">
        <p>Bạn không đủ đẳng cấp để vào</p>
        <a href="<c:url value="/direction"/>">Back</a>
    </div>
</body>
</html>
