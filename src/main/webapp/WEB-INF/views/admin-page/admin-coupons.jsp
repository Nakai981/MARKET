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
<%--    <div class="row">--%>
<%--        <div class="col-8 col-m-12 col-sm-12">--%>
<%--            <div class="card">--%>
<%--                <div class="card-header">--%>
<%--                    <h3>--%>
<%--                        Thêm mới phiếu nhập--%>
<%--                    </h3>--%>
<%--                </div>--%>
<%--                <div class="card-content">--%>
<%--                    <table>--%>
<%--                        <c:if test = "${idSupplier < 1}">--%>
<%--                            <tr>--%>
<%--                                <th> <label>Nhập nhà cung cấp</label></th>--%>
<%--                                <td>--%>
<%--                                    <input type="text" value="${saveId}"${readed} style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " onkeyup="showResult1(this.value)">--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                        </c:if>--%>
<%--                        <c:if test = "${idSupplier > 0}">--%>
<%--                            <c:forEach var="i" items="${saveSupplier}">--%>
<%--                                <tr style="border: 1px  solid #bd4147">--%>
<%--                                    <th style="text-align: right;color: #bd4147">Mã NCC</th>--%>
<%--                                    <td> <c:out value = "${i.getId()}"/></td>--%>
<%--                                    <th style="color: #bd4147;text-align: right">Cung cấp</th>--%>
<%--                                    <td style="text-align: left;color: #bd4147"> <c:out value = "${i.getNameSupplier()}"/><p></td>--%>
<%--                                </tr>--%>
<%--                            </c:forEach>--%>
<%--                        </c:if>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-4 col-m-12 col-sm-12">--%>
<%--            <div class="card">--%>
<%--                <div class="card-header">--%>
<%--                    <h3>--%>
<%--                        Kiểm tra dữ liệu--%>
<%--                    </h3>--%>
<%--                </div>--%>
<%--                <div class="card-content">--%>
<%--                    <td colspan="4"><div id="livesearch"></div></td>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="row">
        <div class="col-5 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-content">
                    <table>
                        <thead>
                        <tr>
                            <th colspan="5"> <a href="/admin/coupons/add" style="padding: 5px 20px;text-decoration: none;color: #fff;font-size: 14px; background: #1e7e34"> + Thêm mới phiếu nhập</a></th>
                        </tr>
                        <tr>
                            <th colspan="5"> Danh sách phiếu nhập</th>
                        </tr>
                        <tr>
                            <th>#</th>
                            <th>Ngày nhập</th>
                            <th>Tên nhân viên</th>
                            <th>Xóa</th>
                            <th>CT</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${importCoupons}">
                            <tr>
                                <td> <c:out value = "${i.getId()}"/><p></td>
                                <td> <c:out value = "${i.getDate()}"/><p></td>
                                <td> <c:out value = "${i.getNameEmployee()}"/><p></td>
                                <td><a style="color: #bd4147"href="#" onclick="alertRemove(${i.getId()})" >
                                    <i class="fas fa-trash-alt"></i></a></td>
                                <td><a style="color: #1e7e34"href="/admin/coupons/detail?id=${i.getId()}"><i class="fas fa-arrow-right"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-7 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Thêm danh sách sản phẩm cho phiếu # ${idCoupon}
                    </h3>
                </div>

                <div class="card-content">
                    <table>
                        <thead>
                        <tr>
                            <td colspan="6">

                                    <form method="get" action="/admin/coupons/detail/add">
                                        <table>
                                            <tr>
                                                <th> <label>Nhập mã lô</label></th>
                                                <td><input type="text" style="height:30px;width: 150px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtMaLo" onkeyup="showsResult2(this.value)">
                                                    <div id="ncc2"></div>
                                                </td>

                                                <th> <label>Nhập nhà cung cấp</label></th>
                                                <td>
                                                    <input type="number"  style="height:30px;width: 150px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtNCC" onkeyup="showResult1(this.value)"/>
                                                    <div id="ncc1"></div>
                                                </td>

                                            </tr>
                                            <tr> <th> <label>Đơn giá</label></th>
                                                <th><input type="number" style="height:30px;width: 150px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtDonGia"size="30"></th>
                                                <th> <label>Số lượng</label></th>
                                                <th><input type="number" style="height:30px;width: 150px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtSL" size="30"></th>
                                            </tr>
                                            <tr>
                                                <td colspan="2"><button style="height: 30px;cursor:pointer;width: 100%;color: white;border: none; background: #bd4147" type="submit" >Thêm mới</button></td>
                                                <td> <button style="height: 30px;cursor:pointer;width: 100%;color: white;border: none; background: #8f8fa1" type="reset" >Nhập lại</button></td>
                                            </tr>
                                        </table>
                                    </form>

                            </td>
                        </tr>
                        <tr>
                            <th>Tên nhà cung cấp</th>
                            <th>Tên mặt hàng</th>
                            <th>SL nhập</th>
                            <th>Giá mua</th>
                            <th>Up</th>
                            <th>Del</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${importCouponsDetail}">
                            <tr>
                                <td> <c:out value = "${i.getNameSupplier()}"/><p></td>
                                <td> <c:out value = "${i.getNameItem()}"/><p></td>
                                <td> <c:out value = "${i.getCount()}"/><p></td>
                                <td> <c:out value = "${i.getPriceCoupon()}"/> VND<p></td>
                                <td><a style="color: #403866" href="#"><i class="fas fa-pen-alt"> </i></a></td>
                                <td><a style="color: #bd4147"href="/admin/supplier/delete?id=${i.getId()}"><i class="fas fa-trash-alt"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-header">
                    <h3>
                        Tổng giá trị phiếu: ${total} VNĐ
                    </h3>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function showResult1(str) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("ncc1").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "api/coupon1?txtNameSearch="+str, true);
        xhttp.send();
    }
    function showsResult2(str) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("ncc2").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "api/shipment?txtIdSearch="+str, true);
        xhttp.send();
    }
    function alertRemove(str){
        if (confirm("Bạn có muốn xóa không")){
            window.location="/admin/coupons/del?id="+str;
        }else{

        }

    }
</script>