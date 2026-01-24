package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HomeServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session != null) {
            session.invalidate();
        }

        Cookie cUser = new Cookie("user", "");
        cUser.setMaxAge(0);
        cUser.setPath("/");
        resp.addCookie(cUser);

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
