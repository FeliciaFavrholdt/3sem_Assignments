package dk.favrholdt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackageDAOTest {

    static EntityManagerFactory emfTest;
    static PackageDAO packageDAO = new PackageDAO();

    @BeforeAll
    static void setUpAll() {
        emfTest = HibernateConfig.getEntityManagerFactoryConfig();
    }

    @AfterAll
    static void tearDown() {
        emfTest.close();
    }

    @Test
    void createPackage() {
        EntityManager entityManager = emfTest.createEntityManager();
        Package pkg = new Package("ABC123", "John", "Camilla", DeliveryStatus.PENDING, "2021-10-10", "12:00:00");
        packageDAO.createPackage(pkg);

        // Retrieve the package from the database and assert its existence
        Package retrievedPackage = entityManager.find(Package.class, pkg.getId());
        Assertions.assertNotNull(retrievedPackage);
        Assertions.assertEquals("ABC123", retrievedPackage.getTrackingNumber());
    }

    @Test
    void readPackage() {
    }

    @Test
    void updatePackage() {

    }

    @Test
    void deletePackage() {
    }

    @Test
    void getAllPackages() {

    }

    @Test
    void getPackageByTrackingNumber() {
    }

    @Test
    void getPackagesByRecipient() {
    }

    @Test
    void updateDeliveryStatus() {
    }
}