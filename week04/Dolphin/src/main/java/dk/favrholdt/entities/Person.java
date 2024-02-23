package dk.favrholdt.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // Relation 1:1
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonDetail personDetail;

    // Relation 1:m
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Fee> fees = new HashSet<>();

    // Relation 1:m
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();

    // Relation 1:m
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<PersonEvent> events = new HashSet<>();

    // Relation m:m
 /*   @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Event> events = new HashSet<>();*/

    public Person(String name) {
        this.name = name;
    }

/*    // uni-directional adds
    public void addEvent(Event event) {
        this.events.add(event);
    }*/

 /*   // uni-directional adds
    public void addEvent(PersonEvent personEvent) {
        this.events.add(personEvent);
    }*/

    // Bi-directional updates
    public void addPersonDetail(PersonDetail personDetail) {
        this.personDetail = personDetail;
        if (personDetail != null) {
            personDetail.setPerson(this);
        }
    }

    public void addFee(Fee fee) {
        this.fees.add(fee);
        if (fee != null) {
            fee.setPerson(this);
        }
    }

    public void addNote(Note note) {
        this.notes.add(note);
        if (note != null) {
            note.setPerson(this);
        }
    }

    public void addEvent(Person person, Event event) {
        PersonEvent personEvent = new PersonEvent();
        personEvent.setPerson(person);
        personEvent.setEvent(event);
        personEvent.setSignupDate(LocalDate.now());
        personEvent.setEventFee(0);
        this.events.add(personEvent);
    }
}