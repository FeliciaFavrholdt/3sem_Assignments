package dk.favrholdt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;


   /*     EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        EntityManager em = emf.createEntityManager();

        Unicorn unicorn = new Unicorn("Roxy", 23, 100);
      *//*  unicorn.setName("unicorn 1");
        unicorn.setAge(23);
        unicorn.setPowerStrength(100);*//*

        em.getTransaction().begin();
        em.persist(unicorn);
        em.getTransaction().commit();
        em.close();

        System.out.println("Hello, " + unicorn.toString());
*/

public class Main {
    public static void main(String[] args) {
        UnicornDAO unicornDAO = new UnicornDAO();

        // Create
        Unicorn newUnicorn = new Unicorn("zaka", 4, 230);
        Unicorn createdUnicorn = unicornDAO.save(newUnicorn);

        // Read
        Unicorn foundUnicorn = unicornDAO.findById(createdUnicorn.getId());
        System.out.println("Found Unicorn: " + foundUnicorn.toString());

        // Update
        foundUnicorn.setAge(23);
        Unicorn updatedUnicorn = unicornDAO.update(foundUnicorn);
        System.out.println("Updated Unicorn Age: " + updatedUnicorn.toString());

        foundUnicorn.setName("tonny");
        Unicorn updatedUnicorn2 = unicornDAO.update(foundUnicorn);
        System.out.println("Updated Unicorn Name: " + updatedUnicorn2.toString());

        // Delete
        //unicornDAO.delete(createdUnicorn.getId());

        // Find All Unicorns
        List<Unicorn> unicorns = unicornDAO.findAll();
        for (Unicorn u : unicorns) {
            System.out.println(u.toString());
        }

        // Find All Unicorns with age > 10 using Java 8 Streams
        List<Unicorn> unicorns2 = unicornDAO.findAll().stream().filter(unicorn -> unicorn.getAge() > 10).toList();
        System.out.println(unicorns2);

        unicornDAO.close();
    }
}