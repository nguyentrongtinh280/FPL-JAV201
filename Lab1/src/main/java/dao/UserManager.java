package dao;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserManager {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("FPL");

    public List<User> findAll() {
        EntityManager em = factory.createEntityManager();
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    public User findById(String userId) {
        EntityManager em = factory.createEntityManager();
        User user = em.find(User.class, userId);
        em.close();
        return user;
    }

    public List<User> findByEmail() {
        EntityManager em = factory.createEntityManager();
        String jpql = "SELECT u FROM User u WHERE u.email LIKE :search AND u.admin = :role";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("search", "%@fpt.edu.vn");
        query.setParameter("role", false);
        List<User> list =  query.getResultList();
        em.close();
        return list;
    }

    public List<User> Page(int number, int size) {
        EntityManager em = factory.createEntityManager();
        String jpql ="SELECT u FROM User u ORDER BY u.id";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setFirstResult(number * size);
        query.setMaxResults(size);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    public void create(User user) {
        EntityManager em = factory.createEntityManager();
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

    public void update(User user) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            System.out.println("User updated");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void deleteById(String userId) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
            } else {
                System.out.println("user not found");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

}
