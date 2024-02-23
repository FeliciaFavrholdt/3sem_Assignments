package dk.favrholdt.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String note; // note text
    private LocalDate created; // date of creation
    private String createdBy; // person who entered the note

    @ToString.Exclude // to avoid stack overflow
    @ManyToOne
    private Person person;

    public Note(String note, LocalDate created, String createdBy) {
        this.note = note;
        this.created = created;
        this.createdBy = createdBy;
    }
}