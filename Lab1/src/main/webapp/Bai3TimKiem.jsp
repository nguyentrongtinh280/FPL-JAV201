<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm video</title>
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
    <form class="row g-2 mb-4"
          action="${pageContext.request.contextPath}/video-search"
          method="get">
        <label class="label-control fw-bold">Tìm kiếm</label>
        <div class="col-md-4">

            <input type="text"
                   name="keyword" class="form-control">
        </div>

        <div class="col-md-2">
            <button type="submit" class="btn btn-primary w-100">
                <i class="fa-solid fa-magnifying-glass"></i> Tìm
            </button>
        </div>
    </form>

    <div class="container mb-4">
        <table class="table table-hover table-bordered text-center">
            <thead>
                <tr class="table-primary">
                    <th>Tiêu đề video</th>
                    <th>Số lượt thích</th>
                    <th>Còn hiệu lực</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${videos}" var="v">
                    <tr>
                        <td>${v.title}</td>
                        <td>${v.views}</td>
                        <td>
                            <c:if test="${v.active}">
                                <span class="badge bg-success">Active</span>
                            </c:if>
                        </td>
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
