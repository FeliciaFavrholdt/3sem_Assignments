package dk.favrholdt.dao;

import dk.favrholdt.config.HibernateConfig;
import dk.favrholdt.model.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.math.BigDecimal;
import java.util.List;

public class DriverDAOImpl implements IDriverDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("recycled");
    EntityManager em = emf.createEntityManager();

    @Override
    public String saveDriver(String name, String surname, BigDecimal salary) {
        Driver driver = new Driver(name, surname, salary);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(driver);
            em.getTransaction().commit();
            em.close();
            return driver.getId();
        }
    }

    @Override
    public Driver getDriverById(String id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Driver driver = em.find(Driver.class, id);
            em.getTransaction().commit();
            em.close();
            return driver;
        }
    }

    @Override
    public Driver updateDriver(Driver driver) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Driver founddriver = getDriverById(driver.getId());
            if (founddriver != null) {
                em.merge(driver);
                em.getTransaction().commit();
                em.close();
                return driver;
            }
            System.out.println("Driver not found");
            return null;
        }
    }

    @Override
    public void deleteDriver(String id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Driver driver = getDriverById(id);
            if (driver != null) {
                em.remove(driver);
                em.getTransaction().commit();
                em.close();
            }
        }
    }

    @Override
    public List<Driver> findAllDriversEmployedAtTheSameYear(String year) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            List<Driver> drivers = em.createQuery("SELECT d FROM Driver d WHERE EXTRACT(YEAR FROM d.employmentDate) = :year", Driver.class)
                    .setParameter("year", year)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
            return drivers;
        }
    }

    @Override
    public List<Driver> fetchAllDriversWithSalaryGreaterThan10000() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            List<Driver> drivers = em.createQuery("SELECT d FROM Driver d WHERE d.salary > 10000", Driver.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
            return drivers;
        }
    }

    @Override
    public BigDecimal fetchHighestSalary() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            BigDecimal highestSalary = em.createQuery("SELECT MAX(d.salary) FROM Driver d", BigDecimal.class)
                    .getSingleResult();
            em.getTransaction().commit();
            em.close();
            return highestSalary;
        }
    }

    @Override
    public List<String> fetchFirstNameOfAllDrivers() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            List<String> firstNames = em.createQuery("SELECT d.name FROM Driver d", String.class)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
            return firstNames;
        }
    }

    @Override
    public long calculateNumberOfDrivers() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            long numberOfDrivers = em.createQuery("SELECT COUNT(d) FROM Driver d", Long.class)
                    .getSingleResult();
            em.getTransaction().commit();
            em.close();
            return numberOfDrivers;
        }
    }

    @Override
    public Driver fetchDriverWithHighestSalary() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Driver driver = em.createQuery("SELECT d FROM Driver d WHERE d.salary = (SELECT MAX(d.salary) FROM Driver d)", Driver.class)
                    .getSingleResult();
            em.getTransaction().commit();
            em.close();
            return driver;
        }
    }
}