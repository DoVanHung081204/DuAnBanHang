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

<form method="post" action="/khach-hang/store">
    <h2>Quan Ly Kich Thuoc
        <h2>

            <div>
                <label>Ten</label>
                <input type="text" name="ten" value="${data.ten}">
                <c:if test="${not empty errors['ten']}">
                    <small style="color: red">${errors["ten"]}</small>
                </c:if>
            </div>
            <div>
                <label>SDT</label>
                <input type="text" name="sdt" value="${data.sdt}">
                <c:if test="${not empty errors['sdt']}">
                    <small style="color: red">${errors["sdt"]}</small>
                </c:if>
            </div>
            <div>
                <label>Ma Khach Hang</label>
                <input type="text" name="maKH" value="${data.maKH}">
                <c:if test="${not empty errors['maKH']}">
                    <small style="color: red">${errors["maKH"]}</small>
                </c:if>
            </div>
            <div>
                <label>Trang Thai</label>
                <select name="trangThai">
                    <option value="0">Dang Hoat Dong</option>
                    <option value="1">Ngung Hoat Dong</option>
                </select>
            </div>
            <button>Luu</button>
</form>
</body>
</html>