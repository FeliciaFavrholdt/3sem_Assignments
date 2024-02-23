package dk.favrholdt.dao;

import dk.favrholdt.config.HibernateConfig;
import dk.favrholdt.model.Driver;
import dk.favrholdt.model.WasteTruck;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class WasteTruckDAOImpl implements IWasteTruckDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("recycled");
    EntityManager em = emf.createEntityManager();

    @Override
    public int saveWasteTruck(String brand, String registrationNumber, int capacity) {
        try (EntityManager em = emf.createEntityManager()) {
            WasteTruck wasteTruck = new WasteTruck(brand, capacity, registrationNumber);
            em.getTransaction().begin();
            em.persist(wasteTruck);
            em.getTransaction().commit();
            em.close();
            return wasteTruck.getId();
        }
    }

    @Override
    public WasteTruck getWasteTruckById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            WasteTruck wasteTruck = em.find(WasteTruck.class, id);
            em.getTransaction().commit();
            em.close();
            return wasteTruck;
        }
    }


    @Override
    public void setWasteTruckAvailable(WasteTruck wasteTruck, boolean available) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            WasteTruck foundWasteTruck = getWasteTruckById(wasteTruck.getId());
            if (foundWasteTruck != null) {
                foundWasteTruck.setAvailable(available);
                em.merge(foundWasteTruck);
                em.getTransaction().commit();
                em.close();
            }
        }

    }

    @Override
    public void deleteWasteTruck(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            WasteTruck wasteTruck = getWasteTruckById(id);
            if (wasteTruck != null) {
                em.remove(wasteTruck);
                em.getTransaction().commit();
                em.close();
            }
        }
    }

    @Override
    public void addDriverToWasteTruck(WasteTruck wasteTruck, Driver driver) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            WasteTruck foundWasteTruck = getWasteTruckById(wasteTruck.getId());
            if (foundWasteTruck != null) {
                foundWasteTruck.addDriver(driver);
                em.merge(foundWasteTruck);
                em.getTransaction().commit();
                em.close();
            }
        }
    }

    @Override
    public void removeDriverFromWasteTruck(WasteTruck wasteTruck, String id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            WasteTruck foundWasteTruck = getWasteTruckById(wasteTruck.getId());
            if (foundWasteTruck != null) {
                foundWasteTruck.removeDriver(foundWasteTruck.getDrivers().stream().filter(driver -> driver.getId().equals(id)).findFirst().orElse(null));
                em.merge(foundWasteTruck);
                em.getTransaction().commit();
                em.close();
            }
        }
    }

    @Override
    public List<WasteTruck> getAllAvailableTrucks() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            List<WasteTruck> wasteTrucks = em.createQuery("SELECT w FROM WasteTruck w WHERE w.isAvailable = true", WasteTruck.class).getResultList();
            em.getTransaction().commit();
            em.close();
            return wasteTrucks;
        }
    }
}