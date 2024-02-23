package dk.favrholdt.dao;

import dk.favrholdt.config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WasteTruckDAOImplTest {
    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    void setUp() {
        emf = HibernateConfig.getEntityManagerFactoryConfig("recycled");
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        emf.close();
    }

    @Test
    void saveWasteTruck() {
    }

    @Test
    void getWasteTruckById() {
    }

    @Test
    void setWasteTruckAvailable() {
    }

    @Test
    void deleteWasteTruck() {
    }

    @Test
    void addDriverToWasteTruck() {
    }

    @Test
    void removeDriverFromWasteTruck() {
    }

    @Test
    void getAllAvailableTrucks() {
    }
}