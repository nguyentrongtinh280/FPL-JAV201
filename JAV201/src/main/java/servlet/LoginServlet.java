package servlet;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;
import filter.AuthFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usernameOrEmail = req.getParameter("usernameOrEmail");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("remember");

        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.Login(usernameOrEmail, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("currentUser", user);
            String securityURI = (String) session.getAttribute(AuthFilter.SECURITY_URI);

            if (rememberMe != null) {
                Cookie cUser = new Cookie("username", usernameOrEmail);
                cUser.setMaxAge(7 * 24 * 60 * 60);

                cUser.setPath(req.getContextPath());
                resp.addCookie(cUser);

            } else {
                Cookie cUser = new Cookie("username", "");
                cUser.setMaxAge(0);
                cUser.setPath(req.getContextPath());
                resp.addCookie(cUser);
            }

            if (securityURI != null) {
                session.removeAttribute(AuthFilter.SECURITY_URI);
                resp.sendRedirect(securityURI);
                return;
            }

            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("loginError", "Sai tên đăng nhập hoặc mật khẩu!");
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);
        }
    }
}
