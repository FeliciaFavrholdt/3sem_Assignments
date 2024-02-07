package APIExercise;

import java.time.LocalDate;

public class MovieDTO {

    private String title;
    private LocalDate releaseDate;

    private String releaseYear;
    private double rating;
    private String id;


    public MovieDTO() {
    }

    public MovieDTO(String title, LocalDate releaseDate, String releaseYear, double rating, String id) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", releaseYear='" + releaseYear + '\'' +
                ", rating=" + rating +
                ", id='" + id + '\'' +
                '}';
    }
}


