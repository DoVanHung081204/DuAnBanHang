<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quản lý Màu Sắc</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Quản lý Màu Sắc</h2>

    <form method="POST" action="/kich-thuoc/update/${ data.id }">
        <div class="form-group">
            <label for="ma">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${ data.ma }" />
            <c:if test="${not empty errors['ma']}">
                <small class="form-text text-danger">${errors["ma"]}</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="ten">Tên</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${ data.ten }" />
            <c:if test="${not empty errors['ten']}">
                <small class="form-text text-danger">${errors["ten"]}</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng thái</label>
            <select class="form-control" id="trangThai" name="trangThai">
                <option value="1" ${ data.trangThai == 1 ? "selected" : "" }>Đang hoạt động</option>
                <option value="0" ${ data.trangThai == 0 ? "selected" : "" }>Ngừng hoạt động</option>
            </select>
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
