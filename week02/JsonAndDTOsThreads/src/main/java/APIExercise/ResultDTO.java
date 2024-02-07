package APIExercise;

import java.time.LocalDate;

public class ResultDTO {

    private String title;
    private LocalDate releaseDate;
    private String releaseYear;
    private double rating;
    private String id;

    public ResultDTO() {
    }

    public ResultDTO(String title, LocalDate releaseDate, String releaseYear, double rating, String id) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", rating=" + rating +
                ", id='" + id + '\'' +
                '}';
    }
}