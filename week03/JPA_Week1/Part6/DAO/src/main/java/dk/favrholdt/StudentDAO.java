package dk.favrholdt;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class StudentDAO implements StudentDAOInterface {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    @Override
    public void createStudent(Student student) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
    }

    @Override
    public Student readStudent(Integer id) {
        try (var em = emf.createEntityManager()) {
            return em.find(Student.class, id);
        }
    }

    @Override
    public void updateStudent(Student student) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteStudent(Student student) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
            return query.getResultList();
        }
    }
}