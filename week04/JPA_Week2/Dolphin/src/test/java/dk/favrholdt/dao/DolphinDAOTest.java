package dk.favrholdt.dao;

import dk.favrholdt.config.HibernateConfig;
import dk.favrholdt.entities.Person;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DolphinDAOTest {

    EntityManagerFactory emf;
    DolphinDAO dolphinDAO;

    @BeforeEach
    void setUp() {
        emf = HibernateConfig.getEntityManagerFactoryConfigForTesting();
        dolphinDAO = new DolphinDAO(emf);
    }

    @AfterEach
    void tearDown() {
        emf.close();
    }

    @Test
    void createPerson() {
    }

    @Test
    void updatePerson() {
    }

    @Test
    void getPersonByID() {
    }

    @Test
    void getTotalAmountPaidByID() {
    }

    @Test
    void getAllNotesForPersonByID() {
    }

    @Test
    void getAllNotesWithNameAndAge() {
    }

    @Test
    void close() {
    }
}