<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Quản lý người dùng</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css"
        integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw=="
        crossorigin="anonymous"
        referrerpolicy="no-referrer"
  />
</head>
<body class="bg-light d-flex flex-column min-vh-100">
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
      <img src="images/logofpt.png" alt="Logo FPT" style="width: 160px">
    </a>

    <button class="navbar-toggler" type="button"
            data-bs-toggle="collapse"
            data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/home">
            <i class="fa-solid fa-house"></i> Trang chủ
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/user">
            <i class="fa-solid fa-user"></i> Người dùng
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/favorite-videos">
            <i class="fa-solid fa-video"></i>Video yêu thích
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/favorite-videos-list">
            <i class="fa-solid fa-bookmark"></i> Danh sách video yêu thích
          </a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/timkiem">
            <i class="fa-solid fa-magnifying-glass"></i> Tìm kiếm
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<main class="container my-4 flex-fill">
  <c:url var="url" value="/user"/>
  <div class="container mt-4">
    <div class="card mb-4">
      <div class="card-header fw-bold bg-primary">
        Quản lý người dùng
      </div>

      <div class="card-body">
        <h2 class="fw-bold text-primary text-center">Thông tin người dùng</h2>
        <form action="${url}" method="post" id="userForm" novalidate>

          <div class="mb-3">
            <label class="form-label fw-bold">Id</label>
            <input type="text" name="id"
                   class="form-control" value="${user.id}" ${isEdit ? 'readonly' : ''} required>
            <div class="valid-feedback">Hợp lệ</div>
            <div class="invalid-feedback">Vui lòng nhập id!</div>
          </div>

          <div class="mb-3">
            <label class="form-label fw-bold">Fullname</label>
            <input type="text" name="fullname"
                   class="form-control" value="${user.fullname}" required>
            <div class="valid-feedback">Hợp lệ</div>
            <div class="invalid-feedback">Vui lòng nhập fullname!</div>
          </div>

          <div class="mb-3">
            <label class="form-label fw-bold">Email</label>
            <input type="email" name="email"
                   class="form-control" value="${user.email}" required>
            <div class="valid-feedback">Hợp lệ</div>
            <div class="invalid-feedback">Vui lòng nhập email!</div>
          </div>

          <div class="mb-3">
            <label class="form-label fw-bold">Password</label>
            <input type="password" name="password"
                   class="form-control" value="${user.password}" required>
            <div class="valid-feedback">Hợp lệ</div>
            <div class="invalid-feedback">Vui lòng nhập password!</div>
          </div>

          <div class="mb-3">
            <label class="form-label me-3 fw-bold">Role</label>
            <div class="form-check form-check-inline">
              <input class="form-check-input role-radio"
                     type="radio" name="admin" value="true"
                     <c:if test="${user != null and user.admin}">checked</c:if>>
              <label class="form-check-label">Admin</label>
            </div>

            <div class="form-check form-check-inline">
              <input class="form-check-input role-radio"
                     type="radio" name="admin" value="false"
                     <c:if test="${user != null and !user.admin}">checked</c:if>>
              <label class="form-check-label">User</label>
            </div>
            <div class="invalid-feedback">Vui lòng chọn role</div>
          </div>

          <div class="mt-3">
            <button formaction="${url}/create" class="btn btn-success">Create</button>
            <button formaction="${url}/update" class="btn btn-warning">Update</button>
            <button formaction="${url}/delete" class="btn btn-danger">Delete</button>
            <button href="${url}/reset" class="btn btn-secondary">Reset</button>
          </div>
        </form>

        <hr>
        <h3 class="fw-bold text-primary">Danh sách người dùng</h3>
        <table class="table table-hover table-bordered align-middle text-center">
          <thead class="table-primary">
          <tr>
            <th>ID</th>
            <th>Fullname</th>
            <th>Email</th>
            <th>Role</th>
            <th>Action</th>
          </tr>
          </thead>

          <tbody>
          <c:forEach items="${users}" var="u">
            <tr>
              <td>${u.id}</td>
              <td>${u.fullname}</td>
              <td>${u.email}</td>
              <td>
                <span class="badge ${u.admin ? 'bg-danger' : 'bg-primary'}">
                    ${u.admin ? 'Admin' : 'User'}
                </span>
              </td>
              <td>
                <a href="${url}/edit?id=${u.id}" class="btn btn-sm btn-info">
                  <i class="bi bi-pencil-square me-1"></i>
                  Edit
                </a>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</main>

<footer class="bg-dark text-white text-center p-3 mt-5">
  <p class="text-center mb-0">JAV201 - Lập trình web nâng cao</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
  const form = document.getElementById("userForm");
  const roleRadios = document.querySelectorAll(".role-radio");
  const actionButtons = document.querySelectorAll("button[formaction]");
  actionButtons.forEach(btn => {
    btn.addEventListener("click", function (event) {
      const action = btn.getAttribute("formaction");
      // Chỉ validate khi Create hoặc Update
      const needValidate = action.includes("create") || action.includes("update");
      // Bật / tắt required cho role
      roleRadios.forEach(radio => {
        radio.required = needValidate;
      });
      if (needValidate) {
        form.classList.add("was-validated");
        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
        }
      }
    });
  });
</script>
</body>
</html>
