<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Quản lý sản phẩm</title>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Quản lý sản phẩm</h2>
    <form method="post" action="/san-pham/store">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" name="ma" class="form-control" value="${data.ma}">
            <c:if test="${not empty errors['ma']}">
                <small class="text-danger">${errors["ma"]}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" name="ten" class="form-control" value="${data.ten}">
            <c:if test="${not empty errors['ten']}">
                <small class="text-danger">${errors["ten"]}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <select name="trangThai" class="form-select">
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>Đang hoạt động</option>
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>Ngừng hoạt động</option>
            </select>
            <c:if test="${not empty errors['trangThai']}">
                <small class="text-danger">${errors["trangThai"]}</small>
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
