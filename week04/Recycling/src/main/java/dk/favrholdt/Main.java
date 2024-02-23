package dk.favrholdt;

import dk.favrholdt.config.HibernateConfig;
import dk.favrholdt.dao.DriverDAOImpl;
import dk.favrholdt.dao.WasteTruckDAOImpl;
import dk.favrholdt.model.Driver;
import dk.favrholdt.model.WasteTruck;
import jakarta.persistence.EntityManagerFactory;

import java.math.BigDecimal;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("recycled");

        WasteTruckDAOImpl wasteTruckDAO = new WasteTruckDAOImpl();
        DriverDAOImpl driverDAO = new DriverDAOImpl();

        // DRIVER //

        //save driver
        driverDAO.saveDriver("Mikkel", "Sørensen", new BigDecimal(10000));

    /*    //get driver by id
        Driver driver = driverDAO.getDriverById("1");

        //update driver
        driver.setSalary(new BigDecimal(15000));
        driverDAO.updateDriver(driver);

        //delete driver
        driverDAO.deleteDriver("1");

        //find all drivers employed at the same year
        System.out.println(driverDAO.findAllDriversEmployedAtTheSameYear("2021"));

        //find all drivers with salary greater than 10000
        System.out.println(driverDAO.fetchAllDriversWithSalaryGreaterThan10000());

        //fetch the highest salary
        System.out.println(driverDAO.fetchHighestSalary());

        //fetch first name of all drivers
        System.out.println(driverDAO.fetchFirstNameOfAllDrivers());

        //calculate number of drivers
        System.out.println(driverDAO.calculateNumberOfDrivers());

        //fetch driver with the highest salary
        System.out.println(driverDAO.fetchDriverWithHighestSalary());

        // TRUCK //

        //save waste truck
        wasteTruckDAO.saveWasteTruck("Volvo", "ABC123", 1000);

        //get waste truck by id
        WasteTruck wasteTruck = wasteTruckDAO.getWasteTruckById(1);

        //set waste truck available
        wasteTruckDAO.setWasteTruckAvailable(wasteTruck, true);

        //delete waste truck
        wasteTruckDAO.deleteWasteTruck(1);

        //add driver to waste truck
        wasteTruckDAO.addDriverToWasteTruck(wasteTruck, driver);

        //remove driver from waste truck
        wasteTruckDAO.removeDriverFromWasteTruck(wasteTruck, "1");

        //get all available trucks
        System.out.println(wasteTruckDAO.getAllAvailableTrucks());*/

        emf.close();
    }
}