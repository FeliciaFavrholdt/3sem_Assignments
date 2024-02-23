package dk.favrholdt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "truck")
public class WasteTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "wasteTruck", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Driver> drivers;

    @Column(name = "brand")
    private String brand;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "registration_number")
    private String RegistrationNumber;

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    public WasteTruck(String brand, Integer capacity, String registrationNumber) {
        this.brand = brand;
        this.capacity = capacity;
        this.RegistrationNumber = registrationNumber;
    }
}