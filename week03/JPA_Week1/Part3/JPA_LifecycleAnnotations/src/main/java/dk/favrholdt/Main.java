package dk.favrholdt;

import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {

    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public static void main(String[] args) {
        // entity is in transient state
       /* Student student = new Student("Jesper", "Thomsen", "JT@gmail.com", 25);
        createStudent(student);*/

        List<Student> students = List.of(
                new Student("Mads", "Jensen", "MadsJ@gmail.com", 51),
                new Student("Sofie", "Madsen", "Sofiegirl@hotmail.com", 17),
                new Student("Karl", "Otto", "K.Otto@outlook.dk", 42),
                new Student("Viktor", "Buch", "Buch@gmail.com", 33),
                new Student("Henrik", "Vejby", "Henrikdensjove@hotmail.com", 65),
                new Student("Chenette", "Amtoftsen", "chennette.A@live.dk", 23),
                new Student("Ruth", "Ingelise", "mormorRuth@gmail.com", 77)
        );

        /* for (Student s : students) {
            createStudent(s);
        }*/

        System.out.println(readStudent(17));

        // Update
        Student updatedStudent = readStudent(17);
        updatedStudent.setFirstName("CONNIE");
        System.out.println("THIS STUDENTS NAME IS UPDATED!");
        System.out.println(updateStudent(17, updatedStudent));

        //deleteStudent(6);
        System.out.println(findAllStudents());
        close();
    }


    //create a new student and persist it to the database
    public static Student createStudent(Student student) {
        try (var em = emf.createEntityManager()) {
            // entity is in transient state
            em.getTransaction().begin();
            // entity is in managed state (after persist)
            em.persist(student);
            // entity is in detached state after the transaction is committed
            em.getTransaction().commit();
            return student;
        }
    }

    //read a student from the database using the student's id
    /*public static Student readStudent(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            Student foundStudent = em.find(Student.class, id);
            em.close();
            return foundStudent;
        }
    }*/ //This is another way to write the method below

    public static Student readStudent(int id) {
        try (var em = emf.createEntityManager()) {
            // entity is in transient state
            return em.find(Student.class, id);
            // entity is in managed state (after find)
        }
    }

    //update an existing students name in the database
    public static Student updateStudent(int id, Student updStd) {
        try (var em = emf.createEntityManager()) {
            // entity is in transient state
            em.getTransaction().begin();

            var student = em.find(Student.class, id);
            // entity is in managed state (after find)

            student.setFirstName(updStd.getFirstName());

            Student merge = em.merge(updStd);
            // entity is in managed state after the transaction is detached by merge
            em.getTransaction().commit();
            // entity is in detached state after the transaction is committed
            em.close();
            return merge;
        }
    }

    //delete a student from the database using the student's id
    public static void deleteStudent(int id) {
        try (var em = emf.createEntityManager()) {
            // entity is in transient state
            em.getTransaction().begin();
            // entity is in managed state (after find)
            var student = em.find(Student.class, id);
            // entity is in removed state (after remove)
            if (student != null) {
                em.remove(student);
            }
            // entity is in detached state after the transaction is committed
            em.getTransaction().commit();
        }
    }

    //retrieve all students from the database and return them as a list. Use a TypedQuery to retrieve all students
    /* public static List<Student> findAllStudents() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
            List<Student> students = query.getResultList();
            em.close();
            return students;
        }
    }*/   //This is another way to write the method below

    public static List<Student> findAllStudents() {
        try (var em = emf.createEntityManager()) {
            // entity is in transient state
            var query = em.createQuery("SELECT s FROM Student s", Student.class);
            // entity is in managed state (after getResultList)
            return query.getResultList();
        }
    }

    public static void close() {
        //close the EntityManagerFactory
        emf.close();
    }
}