<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách video yêu thích</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css"
          integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
    />
</head>
<body class="d-flex flex-column min-vh-100 bg-light">

<jsp:include page="menu.jsp"/>

<main class="container my-4 flex-fill">
    <div class="container mt-4">
        <h3 class="mb-4 text-danger fw-bold text-center">Danh sách top 10 video được yêu thích nhất</h3>
        <table class="table table-bordered table-hover text-center align-middle">
            <thead class="table-primary">
                <tr>
                    <th>Video yêu thích</th>
                    <th>Lượt thích</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="v" items="${top10Video}">
                    <tr>
                        <td>${v.title}</td>
                        <td>${v.favoriteCount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
