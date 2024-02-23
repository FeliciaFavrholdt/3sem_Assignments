package dk.favrholdt;

import dk.favrholdt.config.HibernateConfig;
import dk.favrholdt.dao.DolphinDAO;
import dk.favrholdt.dtos.NoteDTO;
import dk.favrholdt.entities.*;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("dolphin");
        DolphinDAO dolphinDAO = new DolphinDAO(emf);

        //create a new person
        Person p1 = new Person("Mikkel");
        Person p2 = new Person("Helle");

        PersonDetail pd1 = new PersonDetail("Belvederevej 1", 3000, "Helsingør", 26);
        PersonDetail pd2 = new PersonDetail("Kongevejen 30", 3060, "Espergærde", 56);

        p1.addPersonDetail(pd1);
        p2.addPersonDetail(pd2);

        Fee f1 = new Fee(125, LocalDate.of(2023, 8, 25));
        Fee f2 = new Fee(150, LocalDate.of(2023, 11, 19));
        Fee f3 = new Fee(200, LocalDate.of(2024, 1, 11));

        p1.addFee(f1);
        p2.addFee(f2);
        p2.addFee(f3);

        Event e1 = new Event("Birthday", LocalDate.of(2023, 8, 25));
        Event e2 = new Event("Christmas", LocalDate.of(2023, 12, 24));

     /*   p1.addEvent(e1);
        p2.addEvent(e2);*/

        //US-1: As an administrator I would like to be able to add notes to each person, so we can keep track of important information. Each note contains a brief text, the date of creation, and the person who entered the note.
        Note note1 = new Note("Need to buy new fridge", LocalDate.of(2023, 8, 27), "Mikkel");
        Note note2 = new Note("Get present for Sebastian", LocalDate.of(2023, 10, 2), "Mikkel");
        Note note3 = new Note("Plan christmas holiday with mum", LocalDate.of(2023, 10, 11), "Mikkel");

        p1.addNote(note1);
        p1.addNote(note2);
        p2.addNote(note3);

        dolphinDAO.createPerson(p1);
        dolphinDAO.createPerson(p2);


        //US-2: As an administrator I would like to be able to get the total amount paid for a given person.
        dolphinDAO.getTotalAmountPaidByID(p1.getId());
        dolphinDAO.getTotalAmountPaidByID(p2.getId());

        //US-3: As an administrator I would like to be able to get a list of all notes for a given person
        dolphinDAO.getAllNotesForPersonByID(p1.getId());
        dolphinDAO.getAllNotesForPersonByID(p2.getId());

        //US-4: As an administrator I would like to get a list of all notes with the name and age of the person it belongs to.
        List<NoteDTO> noteDTOList = dolphinDAO.getAllNotesWithNameAndAge();
        for (NoteDTO noteDTO : noteDTOList) {
            System.out.println(noteDTO);
        }

        dolphinDAO.close();
    }
}