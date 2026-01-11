package servlet;

import dao.UserDAOImpl;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({
        "/user/create",
        "/user/update",
        "/user/delete",
        "/user/edit/*",
        "/user/reset",
        "/user"
})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        String path = req.getServletPath();
        req.setAttribute("users", userDAO.getAllUsers());

        if (path.contains("/edit")) {
            String id = req.getParameter("id");
           if (id != null) {
               User user = userDAO.getUserById(id);
               req.setAttribute("user", user);
               req.setAttribute("isEdit", true);
           }
        }
        if (path.endsWith("/reset")) {
            req.removeAttribute("user");
        }
        req.getRequestDispatcher("/User.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String path = req.getServletPath();
        if (path.endsWith("/create")) {
            userDAO.createUser(user);
        }
        else if (path.endsWith("/update")) {
            userDAO.updateUser(user);
        } else if (path.endsWith("/delete")) {
            userDAO.deleteUser(user.getId());
        }
        resp.sendRedirect(req.getContextPath() + "/user");
    }
}
