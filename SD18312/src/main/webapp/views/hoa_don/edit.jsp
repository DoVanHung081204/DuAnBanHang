<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="post" action="/hoa-don/update${data.id}">
    <div>
        <label>ID Nhan Vien</label>
        <input type="text" name="idNV" value="${data.idNV}">
        <c:if test="${not empty errors['idNV']}">
            <small style="color: red">${errors["idNV"]}</small>
        </c:if>
    </div>
    <div>
        <label>ID Khach Hang</label>
        <input type="text" name="idKh" value="${data.idKh}">
        <c:if test="${not empty errors['idKh']}">
            <small style="color: red">${errors["idKh"]}</small>
        </c:if>
    </div>
    <div>
        <label>Ngay Mua Hang</label>
        <input type="text" name="ngayMH" value="${data.ngayMH}">
        <c:if test="${not empty errors['ngayMH']}">
            <small style="color: red">${errors["ngayMH"]}</small>
        </c:if>
    </div>
    <div>
        <label>Trang Thai</label>
        <select name="trangThai">
            <option value="0" ${data.trangThai == 0? "selected" : ""}>Dang Hoat Dong</option>
            <option value="1" ${data.trangThai == 1? "selected" : ""}>Ngung Hoat Dong</option>
        </select>
    </div>
    <button>Luu</button>
</form>
</body>
</html>