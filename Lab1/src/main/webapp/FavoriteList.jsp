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
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
            <img src="${pageContext.request.contextPath}/images/logofpt.png" alt="Logo FPT" style="width: 160px">
        </a>

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse"
                data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/home">
                        <i class="fa-solid fa-house"></i> Trang chủ
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/user">
                        <i class="fa-solid fa-user"></i> Người dùng
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/favorite-videos">
                        <i class="fa-solid fa-video"></i>Video yêu thích
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/favorite-videos-list">
                        <i class="fa-solid fa-bookmark"></i> Danh sách video yêu thích
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/video-search">
                        <i class="fa-solid fa-magnifying-glass"></i> Tìm kiếm
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/thong-tin-chia-se-video">
                        <i class="fa-solid fa-bookmark"></i> Thông tin chia sẻ
                    </a>
                </li>
            </ul>

            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link text-warning" href="${pageContext.request.contextPath}/logout">
                        <i class="fa-solid fa-arrow-right-from-bracket"></i> Đăng xuất
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main class="container my-4 flex-fill">
    <div class="container mt-4">
        <h3 class="mb-4 text-danger fw-bold text-center">Danh sách video yêu thích</h3>
        <table class="table table-bordered table-hover text-center align-middle">
            <thead class="table-primary">
                <tr>
                    <th>Video yêu thích</th>
                    <th>Người thích</th>
                    <th>Ngày thích</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="f" items="${favorites}">
                    <tr>
                        <td>${f.video.title}</td>
                        <td>${f.user.fullname}</td>
                        <td>${f.likeDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<footer class="bg-dark text-white text-center p-3 mt-5">
    <p class="text-center mb-0">JAV201 - Lập trình web nâng cao</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
