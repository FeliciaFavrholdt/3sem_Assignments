package dk.favrholdt;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Student(String name, int age, Date createdAt, Date updatedAt) {
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

   /*  With these lifecycle methods in place, every time a Student entity is created or updated,
    the corresponding timestamp fields (createdAt and updatedAt) will be automatically populated
    with the current date and time values. This helps in maintaining accurate records of when
    the entity was created and last updated, without needing manual intervention in the application code.*/


    /*This method is annotated with @PrePersist and is executed before the entity is persisted for
    the first time. It sets the createdAt and updatedAt fields to the current date and time.*/
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    /*This method is annotated with @PreUpdate and is executed before the entity is updated.
    It updates the updatedAt field with the current date and time.*/
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
