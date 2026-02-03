package listener;

import entity.VisitorsCounter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import utils.XJPA;

import java.util.concurrent.atomic.AtomicLong;

@WebListener
public class VisitorsCounterListener implements ServletContextListener, HttpSessionListener {

    private static final int COUNTER_ID = 1;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        EntityManager em = XJPA.getEntityManager();
        long visitors = 0;
        try {
            VisitorsCounter counter = em.find(VisitorsCounter.class, COUNTER_ID);

            if (counter != null) {
                visitors = counter.getTotalVisitors();
            }
        } finally {
            em.close();
        }
        context.setAttribute("visitors", new AtomicLong(visitors));
    }


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        AtomicLong visitors = (AtomicLong) context.getAttribute("visitors");
        visitors.incrementAndGet();
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        AtomicLong visitors = (AtomicLong) context.getAttribute("visitors");

        EntityManager em = XJPA.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            VisitorsCounter counter = em.find(VisitorsCounter.class, COUNTER_ID);

            if (counter == null) {
                counter = new VisitorsCounter();
                counter.setId(COUNTER_ID);
                counter.setTotalVisitors(visitors.get());
                em.persist(counter);
            } else {
                counter.setTotalVisitors(visitors.get());
                em.merge(counter);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }
}
