package dk.favrholdt.dtos;

import dk.favrholdt.entities.Note;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NoteDTO {

    private Note note;
    private String name;
    private int age;
}

