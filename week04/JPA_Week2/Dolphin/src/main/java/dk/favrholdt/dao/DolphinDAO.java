package dk.favrholdt.dao;

import dk.favrholdt.dtos.NoteDTO;
import dk.favrholdt.entities.Note;
import dk.favrholdt.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DolphinDAO {

    private EntityManagerFactory emf;

    //constructor
    public DolphinDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // PERSON //

    //create a new person
    public void createPerson(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
    }

    //update a person
    public Person updatePerson(Person p) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Person updatedPerson = em.find(Person.class, p);
            if (updatedPerson != null) {
                Person person = em.merge(p);
                em.getTransaction().commit();
                return person;
            }
        }
        return null;
    }

    //get a person by id
    public Person getPersonByID(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Person.class, id);
        }
    }

    //get total amount paid for a given person
    public Integer getTotalAmountPaidByID(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Integer> query = em.createQuery("SELECT SUM(f.amount) FROM Fee f WHERE f.person.id = :id", Integer.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    //get a list of all notes for a given person
    public List<Note> getAllNotesForPersonByID(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Note> query = em.createQuery("SELECT n FROM Note n WHERE n.person.id = :id", Note.class);
            query.setParameter("id", id);
            return query.getResultList();
        }
    }

    //get a list of all notes with the name and age of the person it belongs to
    public List<NoteDTO> getAllNotesWithNameAndAge() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<NoteDTO> query = em.createQuery("SELECT new dk.favrholdt.dtos.NoteDTO(n.text, p.name, p.age) FROM Note n JOIN n.person p", NoteDTO.class);
            return query.getResultList();
        }
    }

    //close the entity manager factory
    public void close() {
        emf.close();
    }
}