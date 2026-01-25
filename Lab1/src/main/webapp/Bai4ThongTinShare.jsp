<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thông tin chia sẻ</title>
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
        <table class="table table-hover table-bordered text-center">
            <thead class="table-primary">
                <tr>
                    <th>Tiêu đề video</th>
                    <th>Số lượt chia sẻ</th>
                    <th>Ngày chia sẻ đầu tiên</th>
                    <th>Ngày chia sẻ cuối cùng</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${shareInfoList}" var="s">
                    <tr>
                        <td>${s.title}</td>
                        <td>${s.shareCount}</td>
                        <td>
                            <fmt:formatDate value="${s.firstShareDate}" pattern="dd/MM/yyyy"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${s.lastShareDate}" pattern="dd/MM/yyyy"/>
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
