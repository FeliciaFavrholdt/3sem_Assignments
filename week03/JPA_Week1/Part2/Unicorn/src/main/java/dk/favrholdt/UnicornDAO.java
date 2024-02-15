package dk.favrholdt;

import jakarta.persistence.*;
import java.util.List;

//Data Access Object - klasse der indeholder database metoder
public class UnicornDAO {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    //create
    public Unicorn save(Unicorn unicorn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(unicorn);
        em.getTransaction().commit();
        em.close();
        return unicorn;
    }

    //read
    public Unicorn findById(int id) {
        EntityManager em = emf.createEntityManager();
        Unicorn foundUnicorn = em.find(Unicorn.class, id);
        em.close();
        return foundUnicorn;
    }

    //update
    public Unicorn update(Unicorn unicorn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Unicorn updatedUnicorn = em.merge(unicorn);
        em.getTransaction().commit();
        em.close();
        return updatedUnicorn;
    }

    //delete
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Unicorn unicorn = findById(id);
        if (unicorn != null) {
            em.remove(unicorn);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void close() {
        emf.close();
    }

    public List<Unicorn> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Unicorn u");
        List<Unicorn> unicorns = query.getResultList();
        em.close();
        return unicorns;
    }
}