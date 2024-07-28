<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quan Ly Nhan Vien</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Quản Lý Nhân Viên</h2>

    <form method="post" action="/nhan-vien/store">
        <div class="form-group">
            <label for="ten">Tên</label>
            <input type="text" id="ten" name="ten" class="form-control">
            <c:if test="${not empty errors['ten']}">
                <small class="text-danger">${errors["ten"]}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="maNV">Mã Nhân Viên</label>
            <input type="text" id="maNV" name="maNV" class="form-control">
            <c:if test="${not empty errors['maNV']}">
                <small class="text-danger">${errors["maNV"]}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="tenDN">Tên Đăng Nhập</label>
            <input type="text" id="tenDN" name="tenDN" class="form-control">
            <c:if test="${not empty errors['tenDN']}">
                <small class="text-danger">${errors["tenDN"]}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="mk">Mật Khẩu</label>
            <input type="password" id="mk" name="mk" class="form-control">
            <c:if test="${not empty errors['mk']}">
                <small class="text-danger">${errors["mk"]}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="trangThai">Trạng Thái</label>
            <select id="trangThai" name="trangThai" class="form-control">
                <option value="0">Đang Hoạt Động</option>
                <option value="1">Ngừng Hoạt Động</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
