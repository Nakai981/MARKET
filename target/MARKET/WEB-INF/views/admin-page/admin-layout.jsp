<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 12/18/2020
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/anime-page/fontawesome-free/css/all.min.css"/>">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <!-- End import lib -->
    <link rel="icon" type="image/png" href="<c:url value="/resources/anime-page/assets/AT-pro-logo.png"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/anime-page/style.css"/>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
    <script src="https://unpkg.com/sweetalert2@7.8.2/dist/sweetalert2.all.js"></script>
</head>
<body class="overlay-scrollbar">
<!-- navbar -->
<div class="navbar">
    <!-- nav left -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link">
                <i class="fas fa-bars" onclick="collapseSidebar()"></i>
            </a>
        </li>
        <li class="nav-item">
            <img src="<c:url value="/resources/anime-page/assets/AT-pro-black.png"/>" alt="ATPro logo" class="logo logo-light">
            <img src="<c:url value="/resources/anime-page/assets/AT-pro-white.png"/>" alt="ATPro logo" class="logo logo-dark">
        </li>
    </ul>
    <!-- end nav left -->
    <!-- form -->
    <form class="navbar-search">
        <input type="text" name="Search" class="navbar-search-input" placeholder="What you looking for...">
        <i class="fas fa-search"></i>
    </form>
    <!-- end form -->
    <!-- nav right -->
    <ul class="navbar-nav nav-right">
        <li class="nav-item mode">
            <a class="nav-link" href="#" onclick="switchTheme()">
                <i class="fas fa-moon dark-icon"></i>
                <i class="fas fa-sun light-icon"></i>
            </a>
        </li>

        <li class="nav-item avt-wrapper">
            <div style="padding-top:18px;padding-right:5px; ">
                <form  action="<c:url value="/j_spring_security_logout" />" method="post">
                    <input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input style="border: none;background: #bd4147;color:#fff; padding:5px 7px" class="dropdown-menu-link" type="submit" value="Log out" />
                </form>

            </div>
        </li>
        <li class="nav-item avt-wrapper">
            <div style="padding-top:22px;padding-right:20px; ">
                <span style="font-size: 14px">
                    <c:out value="${user}"/>
                </span>
            </div>

        </li>

    </ul>
    <!-- end nav right -->
</div>
<!-- end navbar -->
<!-- sidebar -->
<div class="sidebar">
    <ul class="sidebar-nav">
        <li class="sidebar-nav-item">
            <a href="/admin" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-tachometer-alt"></i>
                </div>
                <span>
						Nhà
					</span>
            </a>
        </li>
        <li class="sidebar-nav-item">
            <a href="/admin/account" class="sidebar-nav-link ">
                <div>
                    <i class="fab fa-accusoft"></i>
                </div>
                <span>Tài khoản</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="/admin/items" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-tasks"></i>
                </div>
                <span>Mặt hàng</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="/admin/supplier" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-spinner"></i>
                </div>
                <span>Nhà cung cấp</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="/admin/coupons" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-check-circle"></i>
                </div>
                <span>Phiếu nhập</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="/admin/bill" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-bug"></i>
                </div>
                <span>Hóa đơn</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="/admin/inventory" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-chart-line"></i>
                </div>
                <span>Kiểm kê</span>
            </a>
        </li>
    </ul>
</div>
<!-- end sidebar -->

<tiles:insertAttribute name="body"/>
<!-- import script -->
<script  src="<c:url value="/resources/anime-page/index.js"/>"></script>
<!-- end import script -->
</body>
</html>
