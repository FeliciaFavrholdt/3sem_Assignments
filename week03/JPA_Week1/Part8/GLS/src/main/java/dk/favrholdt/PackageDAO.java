package dk.favrholdt;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PackageDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    // Create a new package
    public Package createPackage(Package pkg) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pkg);
        em.getTransaction().commit();
        em.close();
        return pkg;
    }

    // reead a package
    public Package readPackage(String trackingNumber) {
        var em = emf.createEntityManager();
        var pkg = em.find(Package.class, trackingNumber);
        em.close();
        return pkg;
    }

    // update a package
    public Package updatePackage(Package pkg) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pkg);
        em.getTransaction().commit();
        em.close();
        return pkg;
    }

    // delete a package
    public void deletePackage(String trackingNumber) {
        var em = emf.createEntityManager();
        var pkg = em.find(Package.class, trackingNumber);
        em.getTransaction().begin();
        em.remove(pkg);
        em.getTransaction().commit();
        em.close();
    }

    // get a package by tracking number
    public Package getPackageByTrackingNumber(String trackingNumber) {
        var em = emf.createEntityManager();
        var pkg = em.find(Package.class, trackingNumber);
        em.close();
        return pkg;
    }

    //Update the delivery status of a package
    public void updateDeliveryStatus(String trackingNumber, Package.DeliveryStatus deliveryStatus) {
        var em = emf.createEntityManager();
        var pkg = em.find(Package.class, trackingNumber);
        em.getTransaction().begin();
        pkg.setDeliveryStatus(deliveryStatus);
        em.getTransaction().commit();
        em.close();
    }

    // get all packages
    public List<Package> getAllPackages() {
        var em = emf.createEntityManager();
        TypedQuery<Package> query = em.createQuery("SELECT p FROM Package p", Package.class);
        List<Package> packages = query.getResultList();
        em.close();
        return packages;
    }

    // close the EntityManagerFactory
    public void close() {
        emf.close();
    }


}