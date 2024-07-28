
<%@page pageEncoding="UTF-8" language="java" %>
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
<h2>Quan ly Khach Hang</h2>

<form method="POST" action="/khach-hang/update/${ data.id }">
    <div>
        <label>Tên</label>
        <input type="text" name="ten" value="${ data.ten }" />
        <c:if test="${not empty errors['ten']}">
            <small style="color: red">${errors["ten"]}</small>
        </c:if>
    </div>
    <div>
        <label>SDT</label>
        <input type="text" name="sdt" value="${ data.sdt }" />
        <c:if test="${not empty errors['sdt']}">
            <small style="color: red">${errors["sdt"]}</small>
        </c:if>
    </div>
    <div>
        <label>Mã Khach Hang</label>
        <input type="text" name="maKH" value="${ data.maKH }" />
        <c:if test="${not empty errors['maKH']}">
            <small style="color: red">${errors["maKH"]}</small>
        </c:if>
    </div>
    <div>
        <label>Trạng thái</label>
        <select name="trangThai">
            <option value="1" ${ data.trangThai == 1 ? "selected" : "" }>
                Đang hoạt động
            </option>
            <option value="0" ${ data.trangThai == 0 ? "selected" : "" }>
                Ngừng hoạt động
            </option>
        </select>
    </div>
    <div>
        <button>Lưu</button>
    </div>
</form>
</body>
</html>
