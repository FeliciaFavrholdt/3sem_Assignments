package dk.favrholdt;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "point")
public class Point {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "x", nullable = false)
    private int x;

    @Column(name = "y", nullable = false)
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
