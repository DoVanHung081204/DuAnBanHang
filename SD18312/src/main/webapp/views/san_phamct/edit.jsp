
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
<h2>Quan ly san pham chhi tiet</h2>

<form method="POST" action="/san-phamct/update/${ data.id }">
    <div>
        <label>Mã SPCT</label>
        <input type="text" name="maSPCT" value="${ data.ma }" />
        <c:if test="${not empty errors['maSPCT']}">
            <small style="color: red">${errors["maSPCT"]}</small>
        </c:if>
    </div>

    <div>
        <label>ID KT</label>
        <input type="text" name="idKt" value="${ data.idKt }" />
        <c:if test="${not empty errors['idKt']}">
            <small style="color: red">${errors["idKt"]}</small>
        </c:if>
    </div>

    <div>
        <label>ID MS</label>
        <input type="text" name="idMs" value="${ data.idMs }" />
        <c:if test="${not empty errors['idMs']}">
            <small style="color: red">${errors["idMs"]}</small>
        </c:if>
    </div>

    <div>
        <label>San Pham</label>
        <input type="text" name="idSp" value="${ data.sp.ten }" />
        <c:if test="${not empty errors['idSp']}">
            <small style="color: red">${errors["idSp"]}</small>
        </c:if>
    </div>

    <div>
        <label>So Luong</label>
        <input type="text" name="sl" value="${ data.sl }" />
        <c:if test="${not empty errors['sl']}">
            <small style="color: red">${errors["sl"]}</small>
        </c:if>
    </div>

    <div>
        <label>Don Gia</label>
        <input type="text" name="dg" value="${ data.dg }" />
        <c:if test="${not empty errors['dg']}">
            <small style="color: red">${errors["dg"]}</small>
        </c:if>
    </div>

    <div>
        <label>Trạng thái</label>
        <select name="tt">
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
