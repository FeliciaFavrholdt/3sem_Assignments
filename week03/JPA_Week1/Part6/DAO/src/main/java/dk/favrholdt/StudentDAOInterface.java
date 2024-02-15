package dk.favrholdt;

import java.util.List;

public interface StudentDAOInterface {
        void createStudent(Student student);
        Student readStudent(Integer id);
        void updateStudent(Student student);
        void deleteStudent(Student student);
        List<Student> getAllStudents();
    }