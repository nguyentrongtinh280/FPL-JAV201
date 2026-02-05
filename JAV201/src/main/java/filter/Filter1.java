package filter;


import jakarta.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        servletRequest.setAttribute("hello", "Bài 4: Tôi là filter 1");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
