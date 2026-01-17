package dao;

import entity.Favorite;

import java.util.List;

public interface FavoriteDAO {
    void createFavorite(Favorite favorite);
    void updateFavorite(Favorite favorite);
    void deleteFavorite(Long favoriteId);
    List<Favorite> getAllFavorites();

    List<Favorite> findByUser(String userId);

    List<Favorite> findByVideo(String videoId);
}
