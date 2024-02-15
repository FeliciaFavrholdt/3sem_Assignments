package dk.favrholdt;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create an instance of the DAO
        StudentDAO studentDAO = new StudentDAO();

        // Create a new student
        Student student = new Student("Sara", 22, null, null);

        // Create student
        studentDAO.createStudent(student);

        // Read student
        Student foundStudent = studentDAO.readStudent(1);
        System.out.println("Retrieved Student: " + foundStudent);

        // Update student
        foundStudent.setAge(21);
        studentDAO.updateStudent(foundStudent);

        // Delete student
//        studentDAO.deleteStudent(foundStudent);

        // Get all students
        List<Student> students = studentDAO.getAllStudents();
        System.out.println("All Students: " + students);
    }
}