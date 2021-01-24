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
        <div class="col-5 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-content">
                    <table>
                        <thead>
                        <tr>
                            <th colspan="5"> <a href="/admin/inventory/add" style="padding: 5px 20px;text-decoration: none;color: #fff;font-size: 14px; background: #1e7e34"> + Thêm mới phiếu kiểm kê</a></th>
                        </tr>
                        <tr>
                            <th colspan="5"> Danh sách phiếu kiểm kê</th>
                        </tr>
                        <tr>
                            <th>#</th>
                            <th>Ngày lập</th>
                            <th>Tên nhân viên</th>
                            <th>Xóa</th>
                            <th>CT</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${inventories}">
                            <tr>
                                <td> <c:out value = "${i.getId()}"/><p></td>
                                <td> <c:out value = "${i.getDate()}"/><p></td>
                                <td> <c:out value = "${i.getNameEmployee()}"/><p></td>
                                <td><a style="color: #bd4147"href="#" onclick="alertRemove(${i.getId()})" >
                                    <i class="fas fa-trash-alt"></i></a></td>
                                <td><a style="color: #1e7e34"href="/admin/inventory/detail?id=${i.getId()}"><i class="fas fa-arrow-right"></i></a></td>
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
                        Thêm chi tiết cho phiếu # ${idInven}
                </div>

                <div class="card-content">
                    <table>
                        <thead>
                        <tr>
                            <td colspan="6">

                                <form method="get" action="/admin/inventory/detailadd">
                                    <table>
                                        <tr>
                                            <th> <label>Nhập mã lô</label></th>
                                            <td><input type="text" style="height:30px;width: 150px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtMaLo" onkeyup="showsResult2(this.value)" value="${imp.getIdShipment()}">
                                                <div id="ncc2"></div>
                                            </td>
                                            <th> <label>Số lượng tồn</label></th>
                                            <th><input type="number" style="height:30px;width: 150px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtSl"size="30" value="${imp.getPrice()}"></th>
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
                            <th>Tên mặt hàng</th>
                            <th>SL</th>
                            <th>Số lượng tồn</th>
                            <th>Còn lại</th>
                            <th>Up</th>
                            <th>Del</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${inventoriyDetails}">
                            <tr>
                                <td> <c:out value = "${i.getNameShiment()}"/></td>
                                <td> <c:out value = "${i.getCount()}"/></td>
                                <td> <c:out value = "${i.getCounted()}"/></td>
                                <td> <c:out value = "${i.getCo()}"/><p></td>
                                <td><a style="color: #403866" href="#" ><i class="fas fa-pen-alt"> </i></a></td>
                                <td><a style="color: #bd4147"href="#" ><i class="fas fa-trash-alt"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
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
            window.location="/admin/inventory/del?id="+str;
        }else{

        }

    }
</script>
${alert}