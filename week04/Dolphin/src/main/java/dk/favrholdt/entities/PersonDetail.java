package dk.favrholdt.entities;

import dk.favrholdt.entities.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "person_detail")
public class PersonDetail {

    @Id
    private Integer id;
    private String address;
    private int zip;
    private String city;
    private int age;

    // Relation 1:1 to Person
    @OneToOne
    @MapsId
    private Person person;

    public PersonDetail(String address, int zip, String city, int age) {
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.age = age;
    }
}