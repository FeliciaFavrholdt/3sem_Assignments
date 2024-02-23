package dk.favrholdt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Temporal(TemporalType.DATE)
    @Column(name = "employment_date")
    private Date employmentDate;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id", referencedColumnName = "id")
    private WasteTruck wasteTruck;

    //constructor
    public Driver(String name, String surname, BigDecimal salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @PrePersist
    public void generateDriverIdAndEmploymentDate() {
        this.employmentDate = new Date();
        this.id = generateDriverID(this.name, this.surname, this.employmentDate);
    }

    public void addTruck(WasteTruck truck) {
        this.wasteTruck = truck;
    }

    public void removeTruck(WasteTruck truck) {
        this.wasteTruck = null;
    }

    /* The id for the driver should be a string with the format ddMMyy-XX-XXXL.
    ddMMyy is the date of employment, (Date: 2023-08-26 -> String: 230826)
    XX is the first letters of the name and of the surname (Name: John Doe -> String: JD)
    XXX is a random number between 100 and 999
    L is the last letter of the surname (Surname: Doe -> String: E)
    */
    public String generateDriverID(String name, String surname, Date employmentDate) {
        // Format the employment date to ddMMyy format
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        String formattedDate = dateFormat.format(employmentDate);

        // Extract the first letters of the name and surname
        String initials = name.substring(0, 1).toUpperCase() + surname.substring(0, 1).toUpperCase();

        // Generate a random number between 100 and 999
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100;

        // Get the last letter of the surname
        char lastLetter = surname.charAt(surname.length() - 1);

        // Construct the driver ID string
        return formattedDate + "-" + initials + "-" + randomNumber + lastLetter;
    }

    public Boolean validateDriverId(String driverId) {
        return driverId.matches("[0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z][A-Z]-[0-9][0-9][0-9][A-Z]");
    }


}

