package filter;

import dao.LogsDAO;
import dao.LogsDAOImpl;
import dao.UserDAO;
import entity.Logs;
import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter("/*")
public class AppFilter implements Filter {

    private LogsDAO logsDAO = new LogsDAOImpl();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        String username = null;

        if (session != null && session.getAttribute("currentUser") != null) {
            User user = (User) session.getAttribute("currentUser");
            username = user.getUsername();
        }

        Logs log = new Logs();
        log.setUrl(uri);
        log.setAccessTime(LocalDateTime.now());
        log.setUsername(username);

        logsDAO.create(log);

        chain.doFilter(request, response);
    }
}

