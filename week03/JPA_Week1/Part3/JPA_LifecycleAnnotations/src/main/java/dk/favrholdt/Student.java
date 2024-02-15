package dk.favrholdt;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "student")
public class Student {

    @Column(name = "student_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "age")
    private int age;

    @PrePersist
    @PreUpdate
    public void isEmailValid() {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email is not valid");
        }
    }

    //Constructor
    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    //toString method
    public String toString() {
        return "STUDENT " + "\n" +
                "Id: " + id + "\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Age: " + age + "\n" +
                "--------------------------------" + "\n";
    }
}