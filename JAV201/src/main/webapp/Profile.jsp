<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Thông tin cá nhân</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css"
        integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw=="
        crossorigin="anonymous"
        referrerpolicy="no-referrer"
  />
</head>
<body class="d-flex flex-column min-vh-100">

<jsp:include page="menu.jsp"/>

<main class="container my-4 flex-fill">
  <div class="text-center mt-5">
    <c:if test="${not empty sessionScope.currentUser}">
      <h2 class="text-primary fw-bold">THÔNG TIN CÁ NHÂN</h2>
      <p><strong>Họ và tên:</strong> ${sessionScope.currentUser.fullname}</p>
      <p><strong>Email:</strong> ${sessionScope.currentUser.email}</p>
      <p><strong>Tên đăng nhập:</strong> ${sessionScope.currentUser.username}</p>
    </c:if>
  </div>
</main>

<jsp:include page="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
