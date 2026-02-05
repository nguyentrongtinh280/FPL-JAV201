package dao;

import entity.Logs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.XJPA;

public class LogsDAOImpl implements LogsDAO{

    @Override
    public void create(Logs log) {
        EntityManager em = XJPA.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(log);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }
}
