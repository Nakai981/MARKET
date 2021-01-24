<%--
  Created by IntelliJ IDEA.
  User: Phan
  Date: 12/18/2020
  Time: 2:01 AM
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
                        Danh sách nhân viên
                    </h3>
                    <i class="fas fa-plus-square"></i>
                </div>
                <div class="card-content">
                    <table>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Card</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>User</th>
                            <th>Password</th>
                            <th>Position</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${listEmployee}">
                            <tr>


                                <td> <c:out value = "${i.getName()}"/><p></td>

                                <td> <c:if test="${i.getGender() == 0}">
                                    <c:out value="Nam"/><p>
                                        </c:if>
                                        <c:if test="${i.getGender() == 1}">
                                    <c:out value="Nữ"/><p>
                                    </c:if></td>

                                <td> <c:out value = "${i.getCard()}"/></td>
                                <td>0<c:out value = "${i.getPhone()}"/></td>
                                <td><c:out value = "${i.getAddress()}"/></td>
                                <td> <c:out value = "${i.getUser()}"/></td>
                                <td> <c:out value = "${i.getPass()}"/></td>
                                <td> <c:if test="${i.getIdPosition() == 1}">
                                    <c:out value="Admin"/><p>
                                        </c:if>
                                        <c:if test="${i.getIdPosition() == 2}">
                                    <c:out value="User"/><p>
                                    </c:if></td>
                                <td><a style="color: #403866" href="/admin/account/update?id=${i.getId()}"><i class="fas fa-pen-alt"> </i></a></td>
                                <td><a style="color: #bd4147"href="#" onclick="delAcc(${i.getId()})"><i class="fas fa-trash-alt"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <c:forEach var="i" begin="1" end="${sizepage}">
                    <a style="text-decoration: none; padding: 5px 10px; margin-top:45px;margin-left:5px;border:1px solid #1b93e1"href="/admin/account/page?page=${i}">${i}</a>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12 col-m-12 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h3>
                        Thêm & Sửa nhân viên
                    </h3>
                    <i class="fas fa-plus-square"></i>
                </div>
                <div class="card-content">

                    <form method="get" action="/admin/account/add">
                        <table class="table">
                            <tr>
                                <td>
                                        <label>Tên nhân viên</label>
                                        <input type="hidden" name="txtId" value="<c:if test="${empUpdate.getId() != null}">
                                        <c:out value="${empUpdate.getId()}"></c:out>
</c:if> <c:if test="${empUpdate.getId() == null}">
                                        <c:out value="23"></c:out>
</c:if>">
                                </td>
                                <td>
                                    <input type="text"  name="txtName" value="${empUpdate.getName()}" aria-describedby="emailHelp" placeholder="Nhập tên" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 ">
                                </td>
                                <td>
                                    <div class="form-group">
                                        <label>Giới tính</label>

                                    </div>
                                </td>
                                <td>

                                    <select style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtGT" value="${empUpdate.getGender()}">
                                        <option value="0">Nam</option>
                                        <option value="1">Nữ</option>
                                    </select>

                                </td>
                                <td>
                                    <div class="form-group">
                                        <label >CMND</label>

                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">

                                        <input type="text" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 "name="txtCMND" value="${empUpdate.getCard()}" placeholder="CMND">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <label >SĐT</label>

                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">

                                        <input type="text"value="${empUpdate.getPhone()}" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtSDT" placeholder="Nhập SĐT">
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <label >Địa chỉ</label>

                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">

                                        <input type="text" value="${empUpdate.getAddress()}" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtDiaChi"  placeholder="Nhập địa chỉ">
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <label >Username</label>

                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">

                                        <input type="text" value="${empUpdate.getUser()}"style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtUser" placeholder="Username">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="form-group">
                                        <label >Password</label>

                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">

                                        <input type="password" value="${empUpdate.getPass()}"style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtPass"  placeholder="Password">
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <label>Chức vụ</label>

                                    </div>
                                </td>
                                <td>

                                    <select style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 " name="txtCV">
                                        <option value="2">User</option>
                                        <option value="1">Admin</option>
                                        <option value="3">All</option>
                                    </select>

                                </td>

                            </tr>


                            <tr>
                                <td style="margin-left: 10px">
                                    <button style="height: 30px;cursor:pointer;width: 100%;color: white;border: none; background: #1b93e1" type="submit" >${btnUpdate}</button>
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
<script type="text/javascript">
    function delAcc(str){
        if (confirm("Bạn có muốn xóa không")){
            window.location="/admin/account/delete?id="+str;
        }else{

        }
    }
</script>