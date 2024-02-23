package dk.favrholdt;

import dk.favrholdt.entities.Package;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class PackageDAO {
    private EntityManagerFactory emf;

    public PackageDAO(EntityManagerFactory emf) {
        this.emf= emf;
    }

    public void createPackage(Package pkg) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(pkg);
            em.getTransaction().commit();
        }
    }

    public Package update(Package pkg) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Package updatedPackage = em.merge(pkg);
            em.getTransaction().commit();
            return updatedPackage;
        }
    }

    public void delete(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Package pkg = em.find(Package.class, id);
            if (pkg != null) {
                em.remove(pkg);
            }
            em.getTransaction().commit();
        }
    }

    public Package read(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Package.class, id);
        }
    }

    public Package findById(long id){
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Package.class, id);
        }
    }

    public Package findByTrackingNumber(String trackingNumber) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p WHERE p.trackingNumber = :trackingNumber", Package.class);
            query.setParameter("trackingNumber", trackingNumber);
            return query.getSingleResult();
        }
    }

    public Package findBySender(String senderName) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p WHERE p.senderName = :senderName", Package.class);
            query.setParameter("senderName", senderName);
            return query.getSingleResult();
        }
    }
    public Package findByReceiver(String receiverName) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p WHERE p.receiverName = ?1", Package.class);
            query.setParameter(1, receiverName);
            return query.getSingleResult();
        }
    }

    public void updateDeliveryStatus(String number, Package.DeliveryStatus deliveryStatus) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Package pkg = findByTrackingNumber(number);
            pkg.setDeliveryStatus(deliveryStatus);
            em.getTransaction().commit();
        }
    }

    public boolean getPackageByTrackingNumber(String number) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p WHERE p.trackingNumber = :trackingNumber", Package.class);
            query.setParameter("trackingNumber", number);
            return !query.getResultList().isEmpty();
        }
    }

    public void updatePackage(Package pkg) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(pkg);
            em.getTransaction().commit();
        }
    }

    public Package readPackage(String number) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Package.class, number);
        }
    }
}