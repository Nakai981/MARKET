<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="wrapper" style="height: 100%">
    <div class="row">
        <div class="col-5 col-m-12 col-sm-12">
            <div id="card_fuc_2" style="display: none;${ds1}" >
                <div class="card" >
                    <div class="card-header">
                        <h3>
                            Thêm và sửa mặt hàng
                        </h3>
                        <a href="/admin/items"><i class="fas fa-arrow-left" ></i></a>

                    </div>
                    <div class="card-content">
                        ${alert}
                        <form method="get" action="/admin/items/function">
                            <table class="table">
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label>Tên MH</label>
                                            <input type="hidden" name="txtId" value="${item.getId()}"/>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">

                                            <input type="text" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232 "name="txtTen" value="${item.getName()}" placeholder="Tên mặt hàng">
                                        </div>

                                    </td>
                                </tr><tr>
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
                                    <td colspan="2" style="margin-left: 10px">
                                        <button style="height: 30px;cursor:pointer;width: 100%;color: white;border: none; background: #1e7e34" type="submit" >${btnInsert}</button>
                                        <%--                                    <button type="reset" style="height: 30px;width: 70px;color: white;border: none;background: #999999">Nhập lại</button>--%>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <div id="card_fuc_1">
                <div class="card" style="${ds2}">
                    <div class="card-header">
                        <h3>
                            <span>Mặt hàng</span>
                           <input type="text" style="height:30px;width: 250px;outline: none;border: none;border-bottom: 2px solid #323232;margin-left: 10px " onkeyup="showResult1(this.value)" placeholder="Tìm kiếm tên">
                        </h3>
                        <i style="color:#1e7e34"class="fas fa-plus-square" onclick="swipResult()"></i>
                    </div>
                    <div class="card-content" id="livesearch">
                        <table>
                            <thead>
                            <tr>
                                <th>Tên</th>
                                <th>Đơn vị</th>
                                <th>Sửa</th>
                                <th>Xóa</th>
                                <th>Thêm lô</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="i" items="${listItem}">
                                <tr>
                                    <td> <c:out value = "${i.getName()}"/><p></td>
                                    <td> <c:out value = "${i.getUnit()}"/><p></td>
                                    <td><a style="color: #403866" href="/admin/items/update?id=${i.getId()}"><i class="fas fa-pen-alt" onclick="swipResult3()"> </i></a></td>
                                    <td><a style="color: #bd4147"href="#" onclick="delAcc(${i.getId()})"><i class="fas fa-trash-alt"></i></a></td>
                                    <td><a style="color: #1e7e34"href="/admin/items/addShipment?id=${i.getId()}"><i class="fas fa-arrow-right"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

    </div>
        <div class="col-7 col-m-12 col-sm-12">
            <div id="card_fuc_3" style="display: none;${ds3}" >
                <div class="card" >
                    <div class="card-header">
                        <h3>
                            Thêm và sửa lô hàng
                        </h3>
                        <a href="/admin/items"><i class="fas fa-arrow-left" ></i></a>

                    </div>
                    <div class="card-content">
                        ${alert}
                        <form method="get" action="/admin/items/shipment/function">
                            <table class="table">
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label>Mã lô</label>
                                            <input type="hidden" name="txtIdItem" value="${idShipment}"/>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">

                                            <input type="text" style="height:30px;width: 200px;outline: none;border: none;border-bottom: 2px solid #323232 "name="txtMaLo" value="${sp1.getId()}"  placeholder="Mã lô">
                                        </div>

                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <label>Giá bán</label>

                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <input type="number" style="height:30px;width: 200px;outline: none;border: none;border-bottom: 2px solid #323232 "name="txtGiaBan" value="${sp1.getPrice()}" placeholder="Giá tiền">
                                        </div>

                                    </td>
                                </tr><tr>
                                <td>
                                    <div class="form-group">
                                        <label>Hạn sử dụng</label>

                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">

                                        <input type="date" style="height:30px;width: 200px;outline: none;border: none;border-bottom: 2px solid #323232 "name="txtHSD" value="${sp1.getExpiryDate()}" placeholder="Hạn sử dụng">
                                    </div>
                                </td>
                            </tr>


                                <tr>
                                    <td colspan="2" style="margin-left: 10px">
                                        <button style="height: 30px;cursor:pointer;width: 100%;color: white;border: none; background: #1e7e34" type="submit" >${btnInsert1}</button>
                                        <%--                                    <button type="reset" style="height: 30px;width: 70px;color: white;border: none;background: #999999">Nhập lại</button>--%>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <div id="card_fuc_4">
                <div class="card" style="${ds4}">
                    <div class="card-header">
                        <h3>
                            Lô hàng
                        </h3>
                        <i class="fas fa-plus-square" onclick="swipResult2()"></i>
                    </div>
                    <div class="card-content" id="d">
                        <table>
                            <thead>
                            <tr>
                                <th>Mã lô</th>
                                <th>Tên mặt hàng</th>
                                <th>Số lượng</th>
                                <th>Giá bán</th>
                                <th>Hạn sử dụng</th>
                                <th>Sửa</th>
                                <th>Xóa</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="i" items="${listShipment}">
                                <tr>
                                    <td> <c:out value = "${i.getId()}"/><p></td>
                                    <td> <c:out value = "${i.getNameItem()}"/><p></td>
                                    <td> <c:out value = "${i.getCount()}"/><p></td>
                                    <td> <c:out value = "${i.getPrice()}"/><p></td>
                                    <td> <c:out value = "${i.getExpiryDate()}"/><p></td>
                                    <td><a style="color: #403866"
                                            <c:if test="${statusUpdate > 0}">
                                                href="/admin/items/shipment/update?idShipment1=${i.getId()}"
                                            </c:if>
                                            <c:if test="${statusUpdate < 0}">
                                                href="#"
                                            </c:if>
                                    ><i class="fas fa-pen-alt" onclick="swipResult3()"> </i></a></td>
                                    <td><a style="color: #bd4147"href="/admin/items/shipment/del?idShipment1=${i.getId()}"><i class="fas fa-trash-alt"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    function swipResult(){
        document.getElementById("card_fuc_1").style.display="none";
        document.getElementById("card_fuc_2").style.display="inline";
    }
    // function swipResult2(){
    //     document.getElementById("card_fuc_3").style.display="inline";
    //     document.getElementById("card_fuc_4").style.display="none";
    //     alert("hello");
    // }
    function showResult1(str) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("livesearch").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "api/item?txtName="+str, true);
        xhttp.send();
    }
    function delAcc(str){
        if (confirm("Bạn có muốn xóa không")){
            window.location="/admin/items/delete?id="+str;
        }else{

        }
    }
</script>