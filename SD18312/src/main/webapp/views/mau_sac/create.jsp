<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quan Ly Mau Sac</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <form method="post" action="/mau-sac/store">
        <h2 class="mb-4">Quan Ly Mau Sac</h2>

        <div class="form-group">
            <label for="ma">Ma</label>
            <input type="text" class="form-control" id="ma" name="ma">
            <c:if test="${not empty errors['ma']}">
                <small class="form-text text-danger">${errors["ma"]}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="ten">Ten</label>
            <input type="text" class="form-control" id="ten" name="ten">
            <c:if test="${not empty errors['ten']}">
                <small class="form-text text-danger">${errors["ten"]}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="trangThai">Trang Thai</label>
            <select class="form-control" id="trangThai" name="trangThai">
                <option value="0">Dang Hoat Dong</option>
                <option value="1">Ngung Hoat Dong</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Luu</button>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
