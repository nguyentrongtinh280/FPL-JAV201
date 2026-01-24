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
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/video-search">
                        <i class="fa-solid fa-magnifying-glass"></i> Tìm kiếm
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/thong-tin-chia-se-video">
                        <i class="fa-solid fa-bookmark"></i> Thông tin chia sẻ
                    </a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#"
                       role="button" data-bs-toggle="dropdown">
                        <i class="fa-solid fa-video"></i> Quản lý video
                    </a>

                    <ul class="dropdown-menu">
                        <li>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/favorite-videos"><i class="fa-solid fa-video"></i>Video yêu thích</a>
                        </li>
                        <li>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/favorite-videos-list"><i class="fa-solid fa-video"></i>Danh sách video yêu thích</a>
                        </li>
                        <li>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/top-10-video"><i class="fa-solid fa-video"></i>Danh sách top 10 video yêu thích nhất</a>
                        </li>
                    </ul>
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
<footer class="bg-dark text-white text-center p-3 mt-5">
    <p class="text-center mb-0">JAV201 - Lập trình web nâng cao</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
