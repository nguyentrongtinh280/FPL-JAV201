package dao;

import entity.Favorite;
import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.XJPA;

import java.util.List;

public class FavoriteDAOImpl implements FavoriteDAO {

    @Override
    public void createFavorite(Favorite favorite) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(favorite);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void updateFavorite(Favorite favorite) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(favorite);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteFavorite(Long favoriteId) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            Favorite favorite = em.find(Favorite.class, favoriteId);
            if (favorite != null) {
                em.remove(favorite);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Favorite> getAllFavorites() {
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT f FROM Favorite f";
            return em.createQuery(jpql, Favorite.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Favorite> findByUser(String userId) {
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT f From Favorite f WHERE f.user.id = :uid";
            TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
            query.setParameter("uid", userId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Favorite> findByVideo(String videoId) {
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.createQuery(
                            "SELECT f FROM Favorite f WHERE f.video.id = :vid",
                            Favorite.class
                    ).setParameter("vid", videoId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findFavoriteVideosByUser(String userId) {
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT f.video FROM Favorite f WHERE f.user.id = :userId";
            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
