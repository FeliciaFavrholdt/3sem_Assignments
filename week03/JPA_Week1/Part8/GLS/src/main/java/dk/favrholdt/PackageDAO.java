package dk.favrholdt;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PackageDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    // Create a new package
    public void createPackage(Package pkg) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(pkg);
            em.getTransaction().commit();
        }
    }

    // Read package
    public Package readPackage(Integer id) {
        try (var em = emf.createEntityManager()) {
            return em.find(Package.class, id);
        }
    }

    // Update package
    public void updatePackage(Package pkg) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(pkg);
            em.getTransaction().commit();
        }
    }

    // Remove a package from the system
    public void deletePackage(Package pkg) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(pkg);
            em.getTransaction().commit();
        }
    }

    // Get all packages
    public List<Package> getAllPackages() {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p", Package.class);
            return query.getResultList();
        }
    }

    // Retrieve a package by its tracking number
    public Package getPackageByTrackingNumber(String trackingNumber) {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p WHERE p.trackingNumber = :trackingNumber", Package.class);
            query.setParameter("trackingNumber", trackingNumber);
            return query.getSingleResult();
        }
    }

    // Retrieve all packages by a specific recipient
    public List<Package> getPackagesByRecipient(String recieverName) {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p WHERE p.receiverName = :recieverName", Package.class);
            query.setParameter("recieverName", recieverName);
            return query.getResultList();
        }
    }

    // Update the delivery status of a package
    public void updateDeliveryStatus(Package pkg, DeliveryStatus deliveryStatus) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            pkg.setDeliveryStatus(deliveryStatus);
            em.merge(pkg);
            em.getTransaction().commit();
        }
    }
}