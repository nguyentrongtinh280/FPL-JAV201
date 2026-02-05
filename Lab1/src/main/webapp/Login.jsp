<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css"
          integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
    />
</head>
<body>
<div class="container">
    <div class="row justify-content-center align-items-center vh-100">
        <div class="col-md-4">
            <div class="card shadow">
                <div class="card-body">
                    <h3 class="text-center mb-4 fw-bold text-primary">Đăng nhập</h3>

                    <form action="login" method="post" class="was-validated">

                        <div class="mb-3">
                            <label class="form-label fw-bold">Tên đăng nhập hoặc email</label>
                            <input type="text"
                                   name="usernameOrEmail"
                                   class="form-control"
                                   required>

                            <div class="valid-feedback">Hợp lệ</div>
                            <div class="invalid-feedback">Vui lòng nhập username hoặc email!</div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label fw-bold">Mật khẩu</label>
                            <input type="password"
                                   name="password"
                                   class="form-control"
                                   required>
                            <div class="valid-feedback">Hợp lệ</div>
                            <div class="invalid-feedback">Vui lòng nhập mật khẩu!</div>
                        </div>

                        <div class="mb-3 form-check">
                            <input class="form-check-input" type="checkbox"
                                   name="remember" id="remember" >
                            <label class="form-check-label" for="remember">Ghi nhớ đăng nhập</label>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            Đăng nhập
                        </button>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<%
    String loginError = (String) request.getAttribute("loginError");
%>

<% if (loginError != null) { %>
<!-- Modal -->
<div class="modal fade" id="errorModal" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title">
                    <i class="fa-solid fa-triangle-exclamation"></i> Lỗi đăng nhập
                </h5>
                <button type="button" class="btn-close btn-close-white"
                        data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body text-center">
                <br>
                <h5 class="fw-bold text-danger"><%= loginError %></h5>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">
                    Thử lại
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    const errorModal = new bootstrap.Modal(
        document.getElementById('errorModal')
    );
    errorModal.show();
</script>
<% } %>

</body>
</html>
