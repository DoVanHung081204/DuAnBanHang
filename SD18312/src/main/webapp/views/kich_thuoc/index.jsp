<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh Sách Kích Thước</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Danh Sách Kích Thước</h1>

    <form class="row mb-4" action="/kich-thuoc/index">
        <div class="col-md-8">
            <label for="keyword" class="form-label">Tên</label>
            <input id="keyword" name="keyword" class="form-control" />
        </div>
        <div class="col-md-4 d-flex align-items-end">
            <button class="btn btn-light w-100">Tìm kiếm</button>
        </div>
    </form>

    <div class="text-end mb-3">
        <a class="btn btn-success" href="/kich-thuoc/create">Thêm Sản Phẩm</a>
    </div>

    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng Thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="kt">
            <tr>
                <td>${kt.id}</td>
                <td>${kt.ma}</td>
                <td>${kt.ten}</td>
                <td>${kt.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="/kich-thuoc/edit/${kt.id}">Cập nhật</a>
                </td>
                <td>
                    <a class="btn btn-danger btn-sm" href="/kich-thuoc/delete/${kt.id}">Xóa</a>
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
                <a class="page-link" href="/kich-thuoc/index?page=${previousPage}&limit=10">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="/kich-thuoc/index?page=1&limit=10">1</a></li>
            <li class="page-item"><a class="page-link" href="/kich-thuoc/index?page=2&limit=10">2</a></li>
            <li class="page-item"><a class="page-link" href="/kich-thuoc/index?page=3&limit=10">3</a></li>
            <li class="page-item">
                <a class="page-link" href="/kich-thuoc/index?page=${nextPage}&limit=10">Next</a>
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
