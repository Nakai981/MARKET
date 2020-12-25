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
        <div class="col-12 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Danh sách mặt hàng
                    </h3>
                    <i class="fas fa-plus-square"></i>
                </div>
                <div class="card-content">
                    <table>
                        <thead>
                        <tr>
                            <th>CODE</th>
                            <th>Name</th>
                            <th>Unit</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${listItem}">
                            <tr>


                                <td> <c:out value = "${i.getId()}"/><p></td>

                                <td> <c:out value = "${i.getName()}"/><p></td>
                                <td> <c:out value = "${i.getUnit()}"/><p></td>
                                <td><a style="color: #403866" href="/admin/items/update?id=${i.getId()}"><i class="fas fa-pen-alt"> </i></a></td>
                                <td><a style="color: #bd4147"href="/admin/items/delete?id=${i.getId()}"><i class="fas fa-trash-alt"></i></a></td>
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
    <div class="row">
        <div class="col-12 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Thêm & Sửa Hàng hóa
                    </h3>
                    <i class="fas fa-plus-square"></i>
                </div>
                <div class="card-content">

                    <form method="get" action="/admin/items/function">
                        <table class="table">
                            <tr>
                                <td>
                                    <label>CODE</label>
                                </td>
                                <td>
                                    <input type="text"  name="txtCode" value="${item.getId()}" aria-describedby="emailHelp" placeholder="Nhập tên" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 ">
                                </td>
                                <td>
                                    <div class="form-group">
                                        <label>Tên mặt hàng</label>

                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">

                                        <input type="text" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 "name="txtTen" value="${item.getName()}" placeholder="Tên mặt hàng">
                                    </div>

                                </td>
                                <td>
                                    <div class="form-group">
                                        <label >Đơn vị</label>

                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">

                                        <input type="text" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 "name="txtDonVi" value="${item.getUnit()}" placeholder="Đơn vị">
                                    </div>
                                </td>
                            </tr>


                            <tr>
                                <td style="margin-left: 10px">
                                    <button style="height: 30px;cursor:pointer;width: 100%;color: white;border: none; background: #1b93e1" type="submit" >${btnInsert}</button>
                                    <%--                                    <button type="reset" style="height: 30px;width: 70px;color: white;border: none;background: #999999">Nhập lại</button>--%>
                                </td>
                                <td>
                                    <%--                                    <button style="height: 30px;width: 90px;color: white;border: none; background: #1b93e1" type="submit" >Thêm mới</button>--%>
                                    <button type="reset" style="cursor:pointer;height: 30px;width: 100%;color: white;border: none;background: #999999">Nhập lại</button>
                                </td>

                            </tr>
                            <tr>
                                <td colspan="6">
                                    ${alert}
                                </td>
                            </tr>
                        </table>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
