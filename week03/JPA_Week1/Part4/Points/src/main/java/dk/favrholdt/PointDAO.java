package dk.favrholdt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class PointDAO {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    // Store 1000 Point objects in the database:
    public void addData() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();
        em.close();
    }


    // Find the number of Point objects in the database:
    public List<Point> findNumOfObjects() {
        EntityManager em = emf.createEntityManager();

        List<Point> results = em.createQuery("SELECT p FROM Point p", Point.class).getResultList();
        return results;
    }

    // Find the average X value:
    public Double calculateAverageX() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT AVG(p.x) FROM Point p", Point.class);
        Double result = (Double) query.getSingleResult();
        em.close();
        return result;
    }

    // Retrieve all the Point objects from the database:
    public List<Point> retrieveAllObjects() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = new ArrayList<>(query.getResultList());
        em.close();
        return results;
    }

    public void deleteData() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Point");
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void close() {
        emf.close();
    }
}