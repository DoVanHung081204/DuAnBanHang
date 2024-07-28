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
    <title>Quản Lý Kích Thước</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Quản Lý Kích Thước</h2>
    <form method="post" action="/kich-thuoc/store">
        <div class="form-group">
            <label for="ma">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma">
            <c:if test="${not empty errors['ma']}">
                <small class="form-text text-danger">${errors["ma"]}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="ten">Tên</label>
            <input type="text" class="form-control" id="ten" name="ten">
            <c:if test="${not empty errors['ten']}">
                <small class="form-text text-danger">${errors["ten"]}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="trangThai">Trạng Thái</label>
            <select class="form-control" id="trangThai" name="trangThai">
                <option value="0">Đang Hoạt Động</option>
                <option value="1">Ngừng Hoạt Động</option>
            </select>
            <c:if test="${not empty errors['trangThai']}">
                <small class="form-text text-danger">${errors["trangThai"]}</small>
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>

<!-- Bootstrap JS và dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
