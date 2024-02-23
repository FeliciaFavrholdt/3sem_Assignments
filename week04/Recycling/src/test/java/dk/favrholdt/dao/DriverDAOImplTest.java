package dk.favrholdt.dao;

import dk.favrholdt.config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverDAOImplTest {

    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    void setUp() {
        emf = HibernateConfig.getEntityManagerFactoryConfig("recycled");
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {

        em.close();
        emf.close();
    }

    @Test
    void saveDriver() {
    }

    @Test
    void getDriverById() {
    }

    @Test
    void updateDriver() {
    }

    @Test
    void deleteDriver() {
    }

    @Test
    void findAllDriversEmployedAtTheSameYear() {
    }

    @Test
    void fetchAllDriversWithSalaryGreaterThan10000() {
    }

    @Test
    void fetchHighestSalary() {
    }

    @Test
    void fetchFirstNameOfAllDrivers() {
    }

    @Test
    void calculateNumberOfDrivers() {
    }

    @Test
    void fetchDriverWithHighestSalary() {
    }
}