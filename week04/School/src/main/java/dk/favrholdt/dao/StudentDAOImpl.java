package dk.favrholdt.dao;

import dk.favrholdt.dao.IStudentDao;
import dk.favrholdt.entities.Semester;
import dk.favrholdt.entities.Student;
import dk.favrholdt.entities.StudentInfo;
import dk.favrholdt.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentDAOImpl implements IStudentDao {

    private EntityManagerFactory emf;

    public StudentDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Student> findAllStudentsByFirstName(String firstName) {
        try (EntityManager em = emf.createEntityManager()) {
               String sql = String.format("FROM Student s WHERE s.firstName = \'%s\'", firstName);
                TypedQuery<Student> q = em.createQuery(sql, Student.class);
                return q.getResultList();
        }
    }

    @Override
    public List<Student> findAllStudentsByLastName(String lastName) {
        try (EntityManager em = emf.createEntityManager()) {
            String sql = String.format("FROM Student s WHERE s.lastName = \'%s\'", lastName);
            TypedQuery<Student> q = em.createQuery(sql, Student.class);
            return q.getResultList();
        }
    }

    @Override
    public long findTotalNumberOfStudentsBySemester(String semesterName) {
        try (EntityManager em = emf.createEntityManager()) {
            String sql = String.format("SELECT COUNT(s) FROM Student s WHERE s.semester.name = \'%s\'", semesterName);
            TypedQuery<Long> q = em.createQuery(sql, Long.class);
            return q.getSingleResult();
        }
    }

    @Override
    public long findTotalNumberOfStudentsByTeacher(Teacher teacher) {
        try (EntityManager em = emf.createEntityManager()) {
            String sql = String.format("SELECT COUNT(s) FROM Student s JOIN s.semester.teachers t WHERE t.id = %d", teacher.getId());
            TypedQuery<Long> q = em.createQuery(sql, Long.class);
            return q.getSingleResult();
        }
    }

    @Override
    public Teacher findTeacherWithMostSemesters() {
        try (EntityManager em = emf.createEntityManager()) {
            String sql = "SELECT t FROM Teacher t JOIN t.semesters s GROUP BY t.id ORDER BY COUNT(s) DESC";
            TypedQuery<Teacher> q = em.createQuery(sql, Teacher.class);
            return q.getResultList().get(0);
        }
    }

    @Override
    public Semester findSemesterWithFewestStudents() {
        try (EntityManager em = emf.createEntityManager()) {
            String sql = "SELECT s FROM Semester s JOIN s.students st GROUP BY s.id ORDER BY COUNT(st) ASC";
            TypedQuery<Semester> q = em.createQuery(sql, Semester.class);
            return q.getResultList().get(0);
        }
    }

    @Override
    public StudentInfo getAllStudentInfo(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            String sql = String.format("SELECT new dk.favrholdt.entities.StudentInfo(s.firstName, s.lastName, s.semester.name) FROM Student s WHERE s.id = %d", id);
            TypedQuery<StudentInfo> q = em.createQuery(sql, StudentInfo.class);
            return q.getSingleResult();
        }
    }
}