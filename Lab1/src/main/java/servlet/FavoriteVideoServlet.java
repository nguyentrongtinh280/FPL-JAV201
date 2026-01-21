package servlet;

import dao.FavoriteDAOImpl;
import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/favorite-videos")
public class FavoriteVideoServlet extends HttpServlet {
    FavoriteDAOImpl favoriteDAO = new FavoriteDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Video> videos = favoriteDAO.findFavoriteVideosByUser("U001");
        req.setAttribute("videos", videos);
        req.getRequestDispatcher("FavoriteVideo.jsp").forward(req, resp);
    }
}
