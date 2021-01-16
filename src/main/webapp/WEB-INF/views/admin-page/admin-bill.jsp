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
                <div class="card-header">
                    <h3>
                        Danh sách hóa đơn
                    </h3>
                </div>
                <div class="card-content">
                    <form style="margin-left: 10px"method="get" action="/admin/bill/search">
                        <label style="color:#403866;font-size: 15px;font-weight: 700 ">Từ ngày</label>
                        <input type="date"  value="${date1}" name="txtDate1" />
                        <label style="color:#403866;font-size: 15px;font-weight: 700 ">Đến ngày</label>
                        <input type="date" value="${date2}" name="txtDate2"/>
                        <input style="background: #403866; color: white; border: none;margin: 10px 10px 10px 0px;cursor: pointer;padding: 5px 10px"type="submit" value="Lọc"/>
                        <a href="/admin/bill" style="background: #bd4147;margin-left: 3px;color:white;font-size: 12px;padding: 5px 7px;text-decoration: none">Thoát</a>
                    </form>
                    ${alert}
                    <table>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Tên nhân viên</th>
                            <th>Ngày bán</th>
                            <th>Chi tiết</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${listBill}">
                            <tr>
                                <td> <c:out value = "${i.getId()}"/><p></td>
                                <td> <c:out value = "${i.getName_employee()}"/><p></td>
                                <td> <c:out value = "${i.getDate()}"/><p></td>
                                <td><a style="color: #403866" href="/admin/bill/detail?id=${i.getId()}"><i class="fas fa-arrow-circle-right"></i></a></td>
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
                        Danh sách mặt hàng mua #${idS}
                    </h3>
                    <i class="fas fa-plus-square"></i>
                </div>
                <div class="card-content">

                    <table>
                        <thead>
                        <tr>
                            <th>Tên mặt hàng</th>
                            <th>Số lượng</th>
                            <th>Giá bán</th>
                            <th>Tổng tiền</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${billItem}">
                            <tr>
                                <td> <c:out value = "${i.getName_item()}"/><p></td>
                                <td> <c:out value = "${i.getCount()}"/><p></td>
                                <td> <c:out value = "${i.getPrice()}"/><p></td>
                                <td> <c:out value = "${i.getSum_price()}"/><p></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="card-header">
                    <h3>
                        Tổng tiền: ${sum} VNĐ
                    </h3>
                </div>
            </div>
        </div>
    </div>
</div>

