package servlet;

import dao.VideoDAO;
import dao.VideoDAOImpl;
import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/video-search")
public class Bai3TimKiem extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Video> videos;

        if (keyword == null || keyword.isEmpty()) {
            videos = videoDAO.getAllVideos();
        } else {
            videos = videoDAO.findByTitle(keyword);
        }
        req.setAttribute("videos", videos);
        req.getRequestDispatcher("/Bai3TimKiem.jsp").forward(req, resp);
    }
}
