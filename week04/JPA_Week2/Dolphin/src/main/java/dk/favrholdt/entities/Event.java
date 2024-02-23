package dk.favrholdt.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<PersonEvent> persons = new HashSet<>();

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}
