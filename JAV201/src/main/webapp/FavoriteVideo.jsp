<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Video yêu thích</title>
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
        <c:if test="${empty videos}">
            <div class="alert alert-warning">
                Bạn chưa yêu thích video nào.
            </div>
        </c:if>

        <div class="row">
            <c:forEach var="v" items="${videos}">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">

                        <img src="images/${v.poster}"
                             class="card-img-top"
                             style="height:200px; object-fit:cover">

                        <div class="card-body">
                            <h5 class="card-title">${v.title}</h5>

                            <p class="card-text text-muted"
                               style="height:60px; overflow:hidden">
                                    ${v.description}
                            </p>

                            <div class="d-flex justify-content-between align-items-center">
                                <small class="text-muted">
                                    👁 ${v.views} lượt xem
                                </small>

                                <c:if test="${v.active}">
                                    <span class="badge bg-success">Active</span>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
