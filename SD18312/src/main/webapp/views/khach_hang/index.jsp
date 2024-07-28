<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quản Lý Khách Hàng</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Danh Sách Khách Hàng</h1>

    <form class="row mb-4" action="/khach-hang/index">
        <div class="col-md-8">
            <label for="keyword" class="form-label">Tên</label>
            <input id="keyword" name="keyword" class="form-control" />
        </div>
        <div class="col-md-4 d-flex align-items-end">
            <button class="btn btn-light w-100">Tìm kiếm</button>
        </div>
    </form>

    <div class="text-end mb-3">
        <a class="btn btn-success" href="/khach-hang/create">Thêm Khách Hàng</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>SDT</th>
            <th>Mã Khách Hàng</th>
            <th>Trạng Thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ data.content }" var="kh">
            <tr>
                <td>${kh.id}</td>
                <td>${kh.ten}</td>
                <td>${kh.sdt}</td>
                <td>${kh.maKH}</td>
                <td>${kh.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="/khach-hang/edit/${ kh.id }">Cập nhật</a>
                </td>
                <td>
                    <a class="btn btn-danger btn-sm" href="/khach-hang/delete/${kh.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:set var="currentPage" value="${param.page != null ? param.page : 1}" />
    <c:set var="previousPage" value="${currentPage > 1 ? currentPage - 1 : 1}" />
    <c:set var="nextPage" value="${currentPage + 1}" />

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/khach-hang/index?page=${previousPage}&limit=10">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="/khach-hang/index?page=1&limit=10">1</a></li>
            <li class="page-item"><a class="page-link" href="/khach-hang/index?page=2&limit=10">2</a></li>
            <li class="page-item"><a class="page-link" href="/khach-hang/index?page=3&limit=10">3</a></li>
            <li class="page-item">
                <a class="page-link" href="/khach-hang/index?page=${nextPage}&limit=10">Next</a>
            </li>
        </ul>
    </nav>
</div>

<!-- Bootstrap JS và dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
