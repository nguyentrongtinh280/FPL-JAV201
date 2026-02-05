package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();

        boolean isPublicPage =
                uri.equals(contextPath + "/home") ||
                        uri.equals(contextPath + "/") ||
                        uri.endsWith("index.jsp") ||
                        uri.endsWith("Login.jsp") ||
                        uri.endsWith("/video-search") ||
                        uri.endsWith("/thong-tin-chia-se-video") ||
                        uri.endsWith("/favorite-videos") ||
                        uri.endsWith("/favorite-videos-list") ||
                        uri.endsWith("/top-10-video") ||
                        uri.endsWith("/login");

        boolean isResource =
                uri.contains("/css/") ||
                        uri.contains("/js/") ||
                        uri.contains("/images/") ||
                        uri.contains("/fonts/");

        if (isPublicPage || isResource) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        Object user = (session != null) ? session.getAttribute("currentUser") : null;

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
