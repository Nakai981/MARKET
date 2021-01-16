<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 12/25/2020
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="wrapper" style="height: 100%">
    <div class="row">
        <div class="col-8 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Thêm & Sửa nhân viên
                    </h3>
                </div>
                <div class="card-content">
                    <form>
                        <table>
                            <tr>
                                <th> <label>Đơn giá</label></th>
                                <th><input type="text" size="30" onkeyup="showssResult(this.value)"></th>
                                <th> <label>Số lượng</label></th>
                                <th><input type="text" size="30" onkeyup="showssResult(this.value)"></th>
                            </tr>
                            <tr>
                                <th> <label>Nhập nhà cung cấp</label></th>
                                <td>
                                    <input type="text" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " onkeyup="showResult(this.value)">
                                </td>
                                <th> <label>Nhập mặt hàng</label></th>
                                <td><input type="text" size="30" onkeyup="showssResult(this.value)"></td>
                            </tr>
                        </table>


                    </form>
                    <button id="btna" value="huhu"></button>
                </div>
            </div>
        </div>
        <div class="col-4 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Kiểm tra dữ liệu
                    </h3>
                </div>
                <div class="card-content">
                    <td colspan="4"><div id="livesearch"></div></td>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Danh sách các đơn hàng đã nhập
                    </h3>
                    <i class="fas fa-plus-square"></i>
                </div>
                <div class="card-content">
                    <table>
                        <thead>
                        <tr>
                            <th>Name Supplier</th>
                            <th>Date</th>
                            <th>Name Item</th>
                            <th>Count</th>
                            <th>Price</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${listImportCoupons}">
                            <tr>

                                <td> <c:out value = "${i.getNameSupplier()}"/><p></td>
                                <td> <c:out value = "${i.getDate()}"/><p></td>
                                <td> <c:out value = "${i.getNameItem()}"/><p></td>
                                <td> <c:out value = "${i.getCount()}"/><p></td>
                                <td> <c:out value = "${i.getPriceCoupon()}"/> VND<p></td>
                                <td><a style="color: #403866" href="/admin/supplier/update?id=${i.getId()}"><i class="fas fa-pen-alt"> </i></a></td>
                                <td><a style="color: #bd4147"href="/admin/supplier/delete?id=${i.getId()}"><i class="fas fa-trash-alt"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

<%--                <c:forEach var="i" begin="1" end="${sizepage}">--%>
<%--                    <a style="text-decoration: none; padding: 5px 10px; margin-top:45px;margin-left:5px;border:1px solid #1b93e1"href="/admin/account/page?page=${i}">${i}</a>--%>
<%--                </c:forEach>--%>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function showResult(str) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("livesearch").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "api/coupon1?txtNameSearch="+str, true);
        xhttp.send();
    }
</script>