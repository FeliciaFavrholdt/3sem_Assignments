package dk.favrholdt;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Unicorn {

    @Column(name = "unicorn_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "power_strength", nullable = false, length = 100)
    private int powerStrength;

    public Unicorn(String name, int age, int powerStrength) {
        this.name = name;
        this.age = age;
        this.powerStrength = powerStrength;
    }


    public String toString() {
        return "UNICORN " + "\n" +
                "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "PowerStrength: " + powerStrength + "\n" +
                "--------------------------------" + "\n";
    }
}