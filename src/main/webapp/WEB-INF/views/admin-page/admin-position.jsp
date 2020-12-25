<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 12/18/2020
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper" style="height: 100%">
    <div class="row">
        <div class="col-3 col-m-12 col-sm-12">
            <div class="card"><div class="card-header" style="background: #bd4147">
                <a href="/admin/account" style="padding: 15px 20px ;margin:10px 0px; color: white;border: none;text-decoration: none; border-radius: 5px">Quay lại</a></div></div>
        </div></div>
    <div class="row">
        <div class="col-12 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Thêm quyền
                    </h3>
                    <i class="fas fa-plus-square"></i>
                </div>
                <div class="card-content">

                    <form method="post" action="/admin/position/add">
                        <table class="table">
                            <tr>
                                <td>
                                    <label>Phân quyền</label>
                                    <input type="hidden" name="MaNV" value="${MaNV}">
                                </td>

                                <td>

                                    <select style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " name="MaCV" >
                                        <option value="2">User</option>
                                        <option value="1">Admin</option>
                                    </select>

                                </td>
                            </tr>
                            <tr>
                                <td style="margin-left: 10px">
                                    <button style="height: 30px;cursor:pointer;width: 100%;color: white;border: none; background: #1b93e1" type="submit" >Thêm mới</button>
                                    <%--                                    <button type="reset" style="height: 30px;width: 70px;color: white;border: none;background: #999999">Nhập lại</button>--%>
                                </td>
                                <td>
                                    <%--                                    <button style="height: 30px;width: 90px;color: white;border: none; background: #1b93e1" type="submit" >Thêm mới</button>--%>
                                    <button type="reset" style="cursor:pointer;height: 30px;width: 30%;color: white;border: none;background: #999999">Nhập lại</button>
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
    <div class="row">
        <div class="col-12 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Phân quyền tài khoản
                    </h3>
                    <i class="fas fa-plus-square"></i>
                </div>
                <div class="card-content">
                    <table>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Phân quyền</th>
                            <th>Xóa phân quyền</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="i" items="${positionList}">
                            <tr>
                                <td><c:out value="${i.getId()}"/></td>
                                <td><c:out value="${i.getName()}"/></td>
                                <td><a href="/admin/position/delete?MACV=${i.getName()}&MANV=${MaNV}"><i class="fas fa-trash-alt"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
