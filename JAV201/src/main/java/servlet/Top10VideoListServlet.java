package servlet;

import dao.VideoDAO;
import dao.VideoDAOImpl;
import dto.VideoFavoriteInfo;
import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/top-10-video")
public class Top10VideoListServlet extends HttpServlet {

    VideoDAO dao = new VideoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<VideoFavoriteInfo> list = dao.findTop10MostFavoriteVideos();
        req.setAttribute("top10Video", list);
        req.getRequestDispatcher("/Top10VideoList.jsp").forward(req, resp);
    }
}
