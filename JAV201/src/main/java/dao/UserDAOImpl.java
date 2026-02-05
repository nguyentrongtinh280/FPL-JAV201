package dao;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.XJPA;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void createUser(User user){
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void updateUser(User user){
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteUser(String userId){
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
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
    public List<User> getAllUsers(){
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT u FROM User u";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public User getUserById(String userId){
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.find(User.class, userId);
        } finally {
            em.close();
        }
    }

    public User getUserByEmail(String email) {
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT u FROM User u WHERE u.email = :email";

            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public User Login(String emailOrUsername, String password) {
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT u FROM User u WHERE (u.email = :emailOrUsername OR u.username = :emailOrUsername) AND u.password = :password";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("emailOrUsername", emailOrUsername);
            query.setParameter("password", password);
            List<User> list = query.getResultList();
            return list.isEmpty() ? null : list.get(0);
        }  finally{
            em.close();
        }
    }
}
