<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quan ly san pham</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Quản lý sản phẩm</h2>

    <form method="POST" action="/nhan-vien/update/${data.id}">
        <div class="form-group">
            <label for="ten">Tên</label>
            <input type="text" id="ten" name="ten" class="form-control" value="${data.ten}" />
            <c:if test="${not empty errors['ten']}">
                <small class="text-danger">${errors["ten"]}</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="maNV">Mã Nhân Viên</label>
            <input type="text" id="maNV" name="maNV" class="form-control" value="${data.maNV}" />
            <c:if test="${not empty errors['maNV']}">
                <small class="text-danger">${errors["maNV"]}</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="tenDN">Tên Đăng Nhập</label>
            <input type="text" id="tenDN" name="tenDN" class="form-control" value="${data.tenDN}" />
            <c:if test="${not empty errors['tenDN']}">
                <small class="text-danger">${errors["tenDN"]}</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="mk">Mật Khẩu</label>
            <input type="password" id="mk" name="mk" class="form-control" value="${data.mk}" />
            <c:if test="${not empty errors['mk']}">
                <small class="text-danger">${errors["mk"]}</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng thái</label>
            <select id="trangThai" name="trangThai" class="form-control">
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>Đang hoạt động</option>
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>Ngừng hoạt động</option>
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Lưu</button>
        </div>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
