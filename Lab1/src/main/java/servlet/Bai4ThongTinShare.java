package servlet;

import dao.ShareDAO;
import dao.ShareDAOImpl;
import dto.VideoShareInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/thong-tin-chia-se-video")
public class Bai4ThongTinShare extends HttpServlet {

    ShareDAO shareDAO = new ShareDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<VideoShareInfo>  shareInfoList = shareDAO.getVideoShareInfo();
        req.setAttribute("shareInfoList", shareInfoList);
        req.getRequestDispatcher("/Bai4ThongTinShare.jsp").forward(req, resp);
    }
}
