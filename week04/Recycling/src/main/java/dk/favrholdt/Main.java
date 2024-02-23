package dk.favrholdt;

import dk.favrholdt.config.HibernateConfig;
import dk.favrholdt.dao.DriverDAOImpl;
import dk.favrholdt.dao.WasteTruckDAOImpl;
import dk.favrholdt.model.Driver;
import dk.favrholdt.model.WasteTruck;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("recycled");

        WasteTruckDAOImpl wasteTruckDAO = new WasteTruckDAOImpl();
        DriverDAOImpl driverDAO = new DriverDAOImpl();

        // DRIVER //

        //save driver
//        driverDAO.saveDriver("Mikkel", "Sørensen", new BigDecimal(10000));

        //get driver by id
        Driver driver = driverDAO.getDriverById("230224-MS-423n");
        System.out.println(driver);

/*        //update driver
        driver.setSalary(new BigDecimal(15000));
        driverDAO.updateDriver(driver);*/

        //delete driver
//        driverDAO.deleteDriver("7");

        //find all drivers employed at the same year
        System.out.println("Drivers employed at the same year: ");
        List<Driver> drivers = driverDAO.findAllDriversEmployedAtTheSameYear("2021");
        drivers.stream()
                .map(Driver::getName)
                .forEach(System.out::println);

        //find all drivers with salary greater than 10000
        System.out.println("Drivers with salary greater than 10000: ");
        List<Driver> driversWithSalaryGreaterThan10000 = driverDAO.fetchAllDriversWithSalaryGreaterThan10000();
        driversWithSalaryGreaterThan10000.stream()
                .map(Driver::getName)
                .forEach(System.out::println);

        //fetch the highest salary
        System.out.println("Highest salary: ");
        System.out.println(driverDAO.fetchHighestSalary());

        //fetch first name of all drivers
        System.out.println("First name of all drivers: ");
        List<String> firstNames = driverDAO.fetchFirstNameOfAllDrivers();
        for (String name : firstNames) {
            System.out.println(name);
        }

        //calculate number of drivers
        System.out.println("Number of drivers: ");
        System.out.println(driverDAO.calculateNumberOfDrivers());

        //fetch driver with the highest salary
        System.out.println("Driver with the highest salary: ");
        System.out.println(driverDAO.fetchDriverWithHighestSalary().getSalary().toString());

        // TRUCK //

        //save waste truck
//        wasteTruckDAO.saveWasteTruck("Volvo", "ABC123", 1000);

        //get waste truck by id
        WasteTruck wasteTruck = wasteTruckDAO.getWasteTruckById(1);
        System.out.println(wasteTruck);

        //set waste truck available
//        wasteTruckDAO.setWasteTruckAvailable(wasteTruck, true);

        //delete waste truck
//        wasteTruckDAO.deleteWasteTruck(1);

        //add driver to waste truck
//        wasteTruckDAO.addDriverToWasteTruck(wasteTruck, driver);

        //remove driver from waste truck
//        wasteTruckDAO.removeDriverFromWasteTruck(wasteTruck, "1");

        //get all available trucks
        System.out.println(wasteTruckDAO.getAllAvailableTrucks());

        emf.close();
    }
}