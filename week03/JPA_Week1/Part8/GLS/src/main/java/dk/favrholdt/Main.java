package dk.favrholdt;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Instance of PackageDAO
        PackageDAO packageDAO = new PackageDAO();

        // Create a new package
        Package pkg1 = new Package();
        pkg1.setTrackingNumber("1234567890");
        pkg1.setReceiverName("John Doe");
        pkg1.setDeliveryStatus(Package.DeliveryStatus.PENDING);
        packageDAO.createPackage(pkg1);

        // Create a new package
        Package pkg2 = new Package();
        pkg2.setTrackingNumber("0987654321");
        pkg2.setReceiverName("Jane Doe");
        pkg2.setDeliveryStatus(Package.DeliveryStatus.PENDING);
        packageDAO.createPackage(pkg2);

        // Read a package
        Package pkg = packageDAO.readPackage("1234567890");
        System.out.println(pkg);

        // Update a package
        pkg.setDeliveryStatus(Package.DeliveryStatus.IN_TRANSIT);
        packageDAO.updatePackage(pkg);

        // Delete a package
        packageDAO.deletePackage("0987654321");

        // Get a package by tracking number
        Package pkg3 = packageDAO.getPackageByTrackingNumber("1234567890");
        System.out.println(pkg3);

        // Update the delivery status of a package
        packageDAO.updateDeliveryStatus("1234567890", Package.DeliveryStatus.DELIVERED);

        // Close the EntityManagerFactory
        packageDAO.close();
    }
}