package servlet;

import dao.FavoriteDAOImpl;
import entity.Favorite;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/favorite-videos-list")
public class FavoriteVideoListServlet extends HomeServlet {
    private FavoriteDAOImpl favoriteDAO = new FavoriteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Favorite> favorites = favoriteDAO.getAllFavorites();
        req.setAttribute("favorites", favorites);
        req.getRequestDispatcher("/FavoriteList.jsp").forward(req, resp);
    }
}
