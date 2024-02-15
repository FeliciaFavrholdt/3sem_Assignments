package dk.favrholdt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        EntityManager em = emf.createEntityManager();

        //Select all employees
        em.createNamedQuery("Employee.findAll", Employee.class).getResultList().forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        // Get employee by department
        em.createNamedQuery("Employee.findByDepartment", Employee.class)
                .setParameter("department", Employee.Department.IT)
                .getResultList().forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        // Select employees with a salary greater than a certain value
        em.createQuery("SELECT e FROM Employee e WHERE e.salary > 1000", Employee.class).getResultList().forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        // Select employees from a specific department
        em.createQuery("SELECT e FROM Employee e WHERE e.department = 'IT'", Employee.class).getResultList().forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        // Select employees whose first name starts with a certain letter
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.first_Name LIKE 'A%'", Employee.class);
        query.getSingleResult();
        System.out.println("---------------------------------------------------");

        // Update the salary of an employee using a named parameter
        em.getTransaction().begin();
        em.createQuery("UPDATE Employee e SET e.salary = :newSalary WHERE e.id = :id")
                .setParameter("newSalary", 2000)
                .setParameter("id", 1)
                .executeUpdate();
        em.getTransaction().commit();
        System.out.println("---------------------------------------------------");

        //  Update the department of an employee using positional parameters
        em.getTransaction().begin();
        em.createQuery("UPDATE Employee e SET e.department = ?1 WHERE e.id = ?2")
                .setParameter(1, Employee.Department.HR)
                .setParameter(2, 1)
                .executeUpdate();
        em.getTransaction().commit();
        System.out.println("---------------------------------------------------");

        //  Write a JPQL query to calculate the average salary of all employees
        System.out.println(em.createQuery("SELECT AVG(e.salary) FROM Employee e", Double.class).getSingleResult());
        System.out.println("---------------------------------------------------");

        //  Write a JPQL query to calculate the total salary of all employees
        System.out.println(em.createQuery("SELECT SUM(e.salary) FROM Employee e", Double.class).getSingleResult());
        System.out.println("---------------------------------------------------");

        // Close the entity manager
        em.close();
        emf.close();
    }
}