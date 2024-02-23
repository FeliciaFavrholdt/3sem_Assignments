package dk.favrholdt.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;
    String description;

    @OneToMany(mappedBy = "semester")
    Set<Student> students = new HashSet<>();

    @ManyToMany
    Set<Teacher> teachers = new HashSet<>();

    public Semester(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        student.setSemester(this);
        students.add(student);
    }


}