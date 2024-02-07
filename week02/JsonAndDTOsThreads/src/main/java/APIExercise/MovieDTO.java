package APIExercise;

import java.time.LocalDate;

public class MovieDTO {

    private String title;
    private LocalDate releaseDate;
    private String rating;
    private String id;

    public MovieDTO(String title, LocalDate releaseDate, String rating, String id) {
        this.title = title;
        this.releaseDate = LocalDate.parse(releaseDate.toString());
        this.rating = rating;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating='" + rating + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
