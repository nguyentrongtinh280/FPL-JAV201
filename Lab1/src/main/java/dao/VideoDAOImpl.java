package dao;

import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.XJPA;

import java.util.List;

public class VideoDAOImpl implements VideoDAO{

    @Override
    public void createVideo(Video video) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(video);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void updateVideo(Video video) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(video);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteVideo(String videoId) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            Video video = em.find(Video.class, videoId);
            if (video != null) {
                em.remove(video);
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> getAllVideos() {
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT v FROM Video v";
            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Video getVideoById(String videoId) {
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.find(Video.class, videoId);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findActiveVideos() {
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT v FROM Video v WHERE v.active = true",
                    Video.class
            ).getResultList();
        } finally {
            em.close();
        }
    }
}
