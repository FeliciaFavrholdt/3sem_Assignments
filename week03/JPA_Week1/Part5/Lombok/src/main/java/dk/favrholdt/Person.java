package dk.favrholdt;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}

//For those who want to explore further, try adding more Lombok annotations to the Person class like @EqualsAndHashCode, and @Builder and observe the functionalities they bring.