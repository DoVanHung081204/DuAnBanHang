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
<form method="post" action="/hoa-donct/update${data.id}">
    <div>
        <label>ID Hoa Don</label>
        <input type="text" name="idHd" value="${data.idHd}">
        <c:if test="${not empty errors['idHd']}">
            <small style="color: red">${errors["idHd"]}</small>
        </c:if>
    </div>
    <div>
        <label>ID SPCT</label>
        <input type="text" name="idSPCT" value="${data.idSPCT}">
        <c:if test="${not empty errors['idSPCT']}">
            <small style="color: red">${errors["idSPCT"]}</small>
        </c:if>
    </div>
    <div>
        <label>So Luong</label>
        <input type="text" name="sl" value="${data.sl}">
        <c:if test="${not empty errors['sl']}">
            <small style="color: red">${errors["sl"]}</small>
        </c:if>
    </div>
    <div>
        <label>Don Gia</label>
        <input type="text" name="dg" value="${data.dg}">
        <c:if test="${not empty errors['dg']}">
            <small style="color: red">${errors["dg"]}</small>
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