<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Danh Sách Sản Phẩm</title>
    <style>
        .form-container {
            margin-bottom: 20px;
        }
        .form-container form {
            max-width: 400px;
            margin: auto;
        }
        .table-container {
            margin-top: 20px;
        }
        .pagination {
            margin-top: 20px;
        }

        .pagination .page-item.active .page-link {
            background-color: #007bff;
            border-color: #007bff;
        }

        .pagination .page-link {
            color: #007bff;
            border: 1px solid #dee2e6;
        }

        .pagination .page-link:hover {
            z-index: 2;
            color: #0056b3;
            background-color: #e9ecef;
            border-color: #dee2e6;
        }

    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center my-4">Danh Sách Máu Sắc</h1>

    <form class="mt-3 col-8 offset-2" action="/mau-sac/index">
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

    <div class="text-end mb-3">
        <a class="btn btn-success" href="/mau-sac/create">Thêm Sản Phẩm</a>
    </div>

    <div class="table-container">
        <table class="table table-striped table-hover">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Trạng Thái</th>
                <th colspan="2" class="text-center">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ data.content }" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.trangThai == 1 ? "Đang hoạt động" : "Ngừng Hoạt Động"}</td>
                    <td class="text-center">
                        <a class="btn btn-success" href="/mau-sac/edit/${ sp.id }">Cập nhật</a>
                    </td>
                    <td class="text-center">
                        <a class="btn btn-danger" href="/mau-sac/delete/${sp.id}">Xóa</a>
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
                <a class="page-link" href="/mau-sac/index?page=${previousPage}&limit=10">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="/mau-sac/index?page=1&limit=10">1</a></li>
            <li class="page-item"><a class="page-link" href="/mau-sac/index?page=2&limit=10">2</a></li>
            <li class="page-item"><a class="page-link" href="/mau-sac/index?page=3&limit=10">3</a></li>
            <li class="page-item">
                <a class="page-link" href="/mau-sac/index?page=${nextPage}&limit=10">Next</a>
            </li>
        </ul>
    </nav>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
