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
        <li class="nav-item dropdown">
            <a class="nav-link">
                <i class="fas fa-bell dropdown-toggle" data-toggle="notification-menu"></i>
                <span class="navbar-badge">15</span>
            </a>
            <ul id="notification-menu" class="dropdown-menu notification-menu">
                <div class="dropdown-menu-header">
						<span>
							Notifications
						</span>
                </div>
                <div class="dropdown-menu-content overlay-scrollbar scrollbar-hover">
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-gift"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-tasks"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-gift"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-tasks"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-gift"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-tasks"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-gift"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-tasks"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-gift"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-tasks"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-gift"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-tasks"></i>
                            </div>
                            <span>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									<br>
									<span>
										15/07/2020
									</span>
								</span>
                        </a>
                    </li>
                </div>
                <div class="dropdown-menu-footer">
						<span>
							View all notifications
						</span>
                </div>
            </ul>
        </li>
        <li class="nav-item avt-wrapper">
            <div class="avt dropdown">
                <img src="<c:url value="/resources/anime-page/assets/unnamed.png"/>" alt="User image" class="dropdown-toggle" data-toggle="user-menu">
                <ul id="user-menu" class="dropdown-menu">
                    <li  class="dropdown-menu-item">
                        <a class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-user-tie"></i>
                            </div>
                            <span>Profile</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-cog"></i>
                            </div>
                            <span>Settings</span>
                        </a>
                    </li>
                    <li  class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="far fa-credit-card"></i>
                            </div>
                            <span>Payments</span>
                        </a>
                    </li>
                    <li  class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fas fa-spinner"></i>
                            </div>
                            <span>Projects</span>
                        </a>
                    </li>
                    <li  class="dropdown-menu-item">
                        <form action="<c:url value="/j_spring_security_logout" />" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <input class="dropdown-menu-link" type="submit" value="Logout" />
                            <span> <i class="fas fa-sign-out-alt"></i></span>
                        </form>

                    </li>
                </ul>
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
            <a href="#" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-check-circle"></i>
                </div>
                <span>Báo cáo</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="#" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-bug"></i>
                </div>
                <span>Morbi</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="#" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-chart-line"></i>
                </div>
                <span>Praesent</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="#" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-book-open"></i>
                </div>
                <span>Pellentesque</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="#" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-adjust"></i>
                </div>
                <span>Morbi</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="#" class="sidebar-nav-link">
                <div>
                    <i class="fab fa-algolia"></i>
                </div>
                <span>Praesent</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="#" class="sidebar-nav-link">
                <div>
                    <i class="fas fa-audio-description"></i>
                </div>
                <span>Pellentesque</span>
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
