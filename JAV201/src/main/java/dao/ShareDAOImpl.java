package dao;

import dto.VideoShareInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.XJPA;

import java.util.List;

public class ShareDAOImpl implements ShareDAO {

    public List<VideoShareInfo> getVideoShareInfo() {
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT  new dto.VideoShareInfo(s.video.title, COUNT(s), MIN(s.shareDate), MAX(s.shareDate)) FROM Share s " +
                    "GROUP BY s.video.title";

            TypedQuery<VideoShareInfo> query = em.createQuery(jpql, VideoShareInfo.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
