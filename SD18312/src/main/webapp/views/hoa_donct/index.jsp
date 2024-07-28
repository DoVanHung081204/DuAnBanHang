<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Hóa Đơn</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="my-4">Danh Sách Hóa Đơn</h1>

    <form class="row mb-4" action="/hoa-donct/index">
        <div class="col-md-8">
            <label for="keyword" class="form-label">Tên</label>
            <input id="keyword" name="keyword" class="form-control" />
        </div>
        <div class="col-md-4 d-flex align-items-end">
            <button class="btn btn-light w-100">Tìm kiếm</button>
        </div>
    </form>

    <div class="text-end mb-3">
        <a class="btn btn-success" href="/hoa-donct/create">Thêm Hóa Đơn</a>
    </div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>ID Hóa Đơn</th>
            <th>ID SPCT</th>
            <th>Số Lượng</th>
            <th>Đơn Giá</th>
            <th>Trạng Thái</th>
            <th>Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hdct" items="${data.content}">
            <tr>
                <td>${hdct.id}</td>
                <td>${hdct.idHd}</td>
                <td>${hdct.idSPCT}</td>
                <td>${hdct.sl}</td>
                <td>${hdct.dg}</td>
                <td>${hdct.trangThai == 1 ? "Ngưng Hoạt Động" : "Đang Hoạt Động"}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="/hoa-donct/edit/${hdct.id}">Update</a>
                    <a class="btn btn-danger btn-sm" href="/hoa-donct/delete/${hdct.id}">Delete</a>
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
                <a class="page-link" href="/hoa-donct/index?page=${previousPage}&limit=10">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="/hoa-donct/index?page=1&limit=10">1</a></li>
            <li class="page-item"><a class="page-link" href="/hoa-donct/index?page=2&limit=10">2</a></li>
            <li class="page-item"><a class="page-link" href="/hoa-donct/index?page=3&limit=10">3</a></li>
            <li class="page-item">
                <a class="page-link" href="/hoa-donct/index?page=${nextPage}&limit=10">Next</a>
            </li>
        </ul>
    </nav>
</div>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
