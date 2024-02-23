package dk.favrholdt;

import dk.favrholdt.config.HibernateConfig;
import dk.favrholdt.dao.StudentDAOImpl;
import dk.favrholdt.entities.Semester;
import dk.favrholdt.entities.Student;
import dk.favrholdt.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Populate {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        populate(emf);

        StudentDAOImpl studentDAO = new StudentDAOImpl(emf);

        studentDAO.findAllStudentsByFirstName("Hannah").forEach(System.out::println);
        studentDAO.findAllStudentsByLastName("Petersen").forEach(System.out::println);
        System.out.println(studentDAO.findTotalNumberOfStudentsBySemester("DAT23"));
        Teacher teacher = new Teacher("Peter", "Dahl");
        System.out.println(studentDAO.findTotalNumberOfStudentsByTeacher(teacher));
        System.out.println(studentDAO.findTeacherWithMostSemesters());
        System.out.println(studentDAO.findSemesterWithFewestStudents());
        System.out.println(studentDAO.getAllStudentInfo(1));

    }


    private static void populate(EntityManagerFactory emf) {
        // populate the database with data

        Student s1 = new Student("Hannah", "Petersen");
        Student s2 = new Student("Charlie", "Svennson");
        Student s3 = new Student("Camilla", "Due");
        Student s4 = new Student("Pia", "Hansen");
        Student s5 = new Student("Jesper", "Jensen");

        Semester sem1 = new Semester("DAT23", "Datamatiker uddannelsen - CPH - 2023");
        Semester sem2 = new Semester("DAT24", "Datamatiker uddannelsen - AAU - 2024");

        Teacher t1 = new Teacher("Peter", "Dahl");
        Teacher t2 = new Teacher("Simon", "Hansen");
        Teacher t3 = new Teacher("Vivi", "Bach");
        Teacher t4 = new Teacher("Joan", "Smith");


        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            // populate the database with data

            em.persist(s1);
            em.persist(s2);
            em.persist(s3);
            em.persist(s4);
            em.persist(s5);

            em.persist(sem1);
            em.persist(sem2);

            em.persist(t1);
            em.persist(t2);
            em.persist(t3);
            em.persist(t4);

            em.getTransaction().commit();
        }
    }

}