package dk.favrholdt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeAll
    public static void setUp() {
        emf = HibernateConfig.getEntityManagerFactoryConfig();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    @AfterAll
    public static void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    void addData() {
    }

    @Test
    void testFindNumOfObjects() {
    }

    @Test
    void testCalculateAverageX() {
    }

    @Test
    void testRetrieveAllObjects() {
    }

    @Test
    void deleteData() {
    }

    @Test
    void close() {
    }
}