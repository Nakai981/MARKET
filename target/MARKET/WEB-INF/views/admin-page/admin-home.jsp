<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 12/18/2020
  Time: 1:42 AM
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
                        Danh sách mặt hàng hết hạn trong tháng tới
                    </h3>
                </div>
                <div class="card-content">
                    <form method="get" action="/admin/home/detail">
                        <label style="color:#403866;margin: 0px 10px;font-size: 15px;font-weight: 700 ">Tháng tới</label>
                        <input type="number" name="i" value="${idd}" placeholder="Nhập số"/>
                        <input style="background: #403866; color: white; border: none;margin: 10px 10px 10px 0px;cursor: pointer;padding: 3px 10px" type="submit" value="Thực thi"/>
                    </form>
                    <table>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Hạn sử dụng</th>
                            <th>Tên mặt hàng</th>
                            <th>Số lượng</th>
                            <th>Giá bán</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${listExpiry}">
                            <tr>
                                <td> <c:out value = "${i.getId()}"/><p></td>
                                <td> <c:out value = "${i.getExpiryDate()}"/><p></td>
                                <td> <c:out value = "${i.getNameItem()}"/><p></td>
                                <td> <c:out value = "${i.getCount()}"/><p></td>
                                <td> <c:out value = "${i.getPrice()}"/><p></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-4 col-m-12 col-sm-12">
        <div class="card">
            <div class="card-header">
                <h3>
                    Tổng doanh thu theo ngày tháng năm
                </h3>
            </div>
            <div class="card-content">
                <form style="margin-left: 10px"method="get" action="/admin/home/date">
                    <table>
                        <tr>
                            <td><label style="color:#403866;font-size: 15px;font-weight: 700 ">Chọn thời gian</label></td>
                            <td> <input type="date"  value="${date}" name="txtDate" /></td>
                        </tr>
                        <tr>
                            <td><label style="color:#403866;font-size: 15px;font-weight: 700 ">Chọn mốc</label></td>
                            <td>
                                <select name="txtSelect" >
                                    <option value="1">Ngày</option>
                                    <option value="2">Tháng</option>
                                    <option value="3">Năm</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"> <input style="background: #403866; color: white; border: none;margin: 10px 10px 10px 0px;cursor: pointer;padding: 5px 10px"type="submit" value="Lọc"/></td>
                        </tr>
                    </table>

                </form>
                <b>Tổng tiền thu vào: ${sumBill} VNĐ</b>
            </div>
        </div>
    </div>
    </div>

</div>
