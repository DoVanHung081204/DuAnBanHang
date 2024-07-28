<%@page language="java" pageEncoding="UTF-8" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<div class="col-10 offset-1">

    <form class="mt-3 col-8 offset-2" action="/san-phamct/index">
        <div class="row">
            <div class="col-8">
                <label class="col-2">Tên</label>
                <div class="col-10">
                    <input name="keyword" class="form-control" />
                </div>
            </div>
            <div class="mt-2 col-3">
                <button class="btn btn-light">Tìm kiếm</button>
            </div>
        </div>
    </form>

    <div class="col-10 offset-1">
        <table class="table table-stripped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Sản phẩm</th>
                <th>Màu sắc</th>
                <th>Kích thước</th>
                <th>Mã SPCT</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Trạng thái</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ data.content }" var="spct">
                <tr>
                    <td>${ spct.id }</td>
                    <td>${ spct.sp.ten }</td>

                    <td>${ spct.idMs }</td>
                    <td>${ spct.idKt }</td>
                    <td>${ spct.ma }</td>
                    <td>${ spct.sl }</td>
                    <td>${ spct.dg }</td>
                    <td>${ sp.tt == 1 ? "Dang hoat dong" : "Ngung hoat dong" }</td>
                    <td>
                        <a href="/san-phamct/edit/${ spct.id }">Update</a>
                    </td>
                    <td>
                        <a href="/san-phamct/delete/${ spct.id }">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <c:set var="currentPage" value="${param.page != null ? param.page : 1}" />
    <c:set var="previousPage" value="${currentPage > 1 ? currentPage - 1 : 1}" />
    <c:set var="nextPage" value="${currentPage + 1}" />

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/san-phamct/index?page=${previousPage}&limit=10">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="/san-phamct/index?page=1&limit=10">1</a></li>
            <li class="page-item"><a class="page-link" href="/san-phamct/index?page=2&limit=10">2</a></li>
            <li class="page-item"><a class="page-link" href="/san-phamct/index?page=3&limit=10">3</a></li>
            <li class="page-item">
                <a class="page-link" href="/san-phamct/index?page=${nextPage}&limit=10">Next</a>
            </li>
        </ul>
    </nav>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>