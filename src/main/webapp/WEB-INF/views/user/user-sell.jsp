<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 1/22/2021
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="wrapper">

    <div class="menu">
        <a href="/user/create">Tạo hóa đơn</a>
        <a href="#">Báo cáo</a>
        <form class="logout" action="<c:url value="/j_spring_security_logout" />" method="post">
            <span>${user}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input class="login100-form-btn" type="submit" value="Logout"/>
        </form>
    </div>

    <div class="search-input">
        <a href="" target="_blank" hidden></a>

        <input type="text" onkeyup="showResult1(this.value)" placeholder="Nhập mã sản phẩm or tên sản phẩm ...">

        <div class="autocom-box" id="autocom-box">
        </div>
        <div class="icon"><i class="fas fa-search"></i></div>

    </div>
    <div class="autocom-box-1">
        <div class="box-1">
            <table width=100%>
                <tbody>
                <tr>
                    <td colspan="4"><h4>Mã hóa đơn # ${idBill} ${b}</h4></td>
                </tr>
                <tr>
                    <th>Tên sản phẩm</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                </tr>
                </tbody>
                <c:forEach var="i" items="${listBill}">
                    <tr>
                        <td> <c:out value = "${i.getName_item()}"/><p></td>
                        <td> <c:out value = "${i.getPrice()}"/><p></td>
                        <td>  <form method="get" action="/user/tg">
                            <input type="number" name="count1" value="<c:out value = "${i.getCount()}"/>"/>
                            <input type="hidden" name="idLo" value="<c:out value = "${i.getName_employee()}"/>"/>
                        </form>
                        </td>
                        <td> <c:out value = "${i.getSum_price()}"/> VND<p></td>
                        <td><a style="color: #bd4147"href="/user/del?idLo=${i.getName_employee()}"><i class="fas fa-trash-alt"></i></a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <th colspan="3" >Tổng tiền</th>
                    <th>${sumPrice} VNĐ</th>
                </tr>
                <tr>
                    <td colspan="4"><a href="/user/insert">Thanh toán</a></td>
                </tr>
                <tr>
                    <td  colspan="4"><a href="/user/cancel">Hủy</a></td>
                </tr>


            </table>
        </div>
    </div>
</div>
${type}
<script type="text/javascript">
    const searchWrapper = document.querySelector(".search-input");
    const inputBox = searchWrapper.querySelector("input");
    const suggBox = searchWrapper.querySelector(".autocom-box");

    function showResult1(str) {
        searchWrapper.classList.add("active");
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("autocom-box").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "user/api/item/bill?txtName="+str, true);
        xhttp.send();
    }
    function show(str){
        // alert(str);

        let hreff = "/user/listitem?idLo="+str;
        //alert(hreff);
        window.location = "/user/listitem?idLo="+str;
        searchWrapper.classList.remove("active");

    }
</script>

