package dk.favrholdt;

public class Main {
    public static void main(String[] args) {

    /*    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        EntityManager em = emf.createEntityManager();

        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());

        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }*/ //CODE FROM THE EXERCISE

    PointDAO pointDAO = new PointDAO();

        // Store 1000 Point objects in the database:
        System.out.println("Adding 1000 Point objects to the database...");
        pointDAO.addData();

        // Find the number of Point objects in the database:
        System.out.println("Number of Point objects in the database: " + pointDAO.findNumOfObjects().size());

        // Find the average X value:
        System.out.println("Average X value: " + pointDAO.calculateAverageX());

        // Retrieve all the Point objects from the database:
        System.out.println("All Point objects in the database:");
        for (Point p : pointDAO.retrieveAllObjects()) {
            System.out.println(p.toString());
        }

        // Delete all the Point objects from the database:
        /*pointDAO.deleteData();
        System.out.println("Number of Point objects in the database after deletion: " + pointDAO.findNumOfObjects().size());*/

        // Close the EntityManagerFactory:
        pointDAO.close();
    }
}