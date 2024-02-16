package dk.favrholdt;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Instance of PackageDAO
        PackageDAO packageDAO = new PackageDAO();

        // Create a new package
        Package pkg1 = new Package("1234567890", "GLS", "John Doe", Package.DeliveryStatus.PENDING, "2021-09-01 12:00:00");
        Package pkg2 = new Package("0987654321", "GLS", "Jane Doe", Package.DeliveryStatus.PENDING, "2021-09-01 12:00:00");
        Package pkg3 = new Package("1357924680", "GLS", "Rikke", Package.DeliveryStatus.PENDING, "2021-09-01 12:00:00");
        Package pkg4 = new Package("2468135790", "GLS", "Mads", Package.DeliveryStatus.PENDING, "2021-09-01 12:00:00");

        packageDAO.createPackage(pkg1);
        packageDAO.createPackage(pkg2);
        packageDAO.createPackage(pkg3);
        packageDAO.createPackage(pkg4);

        List<Package> packages = List.of(pkg1, pkg2, pkg3, pkg4);
        System.out.println(packages);

        // Read a package
        Package pkg = packageDAO.readPackage("1234567890");
        System.out.println(pkg);
        // Update a package
        pkg.setDeliveryStatus(Package.DeliveryStatus.IN_TRANSIT);
        packageDAO.updatePackage(pkg);

        // Delete a package
        //packageDAO.deletePackage("0987654321");

        // Get a package by tracking number
        System.out.println(packageDAO.getPackageByTrackingNumber("0987654321"));

        // Update the delivery status of a package
        packageDAO.updateDeliveryStatus("0987654321", Package.DeliveryStatus.DELIVERED);

        // Close the EntityManagerFactory
        packageDAO.close();
    }
}